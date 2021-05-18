package com.example.lab11.service;


import com.example.lab11.entity.Person;
import com.example.lab11.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(long id) {
        return personRepository.findById(id);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(long id) {
        personRepository.deleteById(id);
    }

    public Person addFriend(Person p, Person friend){
        p.addFriend(friend.getId());
        friend.addFriend(p.getId());
        personRepository.save(p);
        personRepository.save(friend);
        return p;
    }

    public List<Person> findPopular(int k){
        var persons = personRepository.findAll();
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getFriends().size(), o2.getFriends().size());
        }});
        return persons.subList(0, k);
    }

    public List<Person> findUnpopular(int k){
        var persons = personRepository.findAll();
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o2, Person o1) {
                return Integer.compare(o1.getFriends().size(), o2.getFriends().size());
            }});
        return persons.subList(0, k);
    }

}
