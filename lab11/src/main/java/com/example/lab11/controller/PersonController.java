package com.example.lab11.controller;

import com.example.lab11.entity.Person;
import com.example.lab11.service.PersonService;
import com.example.lab11.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons(){

            List<Person> persons = new ArrayList<Person>();
                personService.findAll().forEach(persons::add);

            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        Person personData = personService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found Person with id = " + id));

        return new ResponseEntity<>(personData, HttpStatus.OK);

    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
            Person _person = personService
                    .save(new Person(person.getName()));
            return new ResponseEntity<>(_person, HttpStatus.CREATED);

    }

    @PostMapping("/persons/{id}/addFriend/{friendId}")
    public ResponseEntity<Person> addFriend(@PathVariable("id") long id, @PathVariable("friendId") long friendId ){
            Person person = personService.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Not found Person with id = " + id));
            Person friend = personService.findById(friendId).orElseThrow(
                    () -> new ResourceNotFoundException("Not found Person with id = " + id));
                Person _person = personService.addFriend(person, friend);

                return new ResponseEntity<>(_person, HttpStatus.CREATED);
    }

    @GetMapping("/persons/{id}/friends")
    public ResponseEntity<List<Long>> getFriends(@PathVariable("id") long id) {
        Person personData = personService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found Person with id = " + id));

            return new ResponseEntity<>(personData.getFriends(), HttpStatus.OK);
    }

    @GetMapping("/persons/polular/{first}")
    public ResponseEntity<List<Person>> getPopular(@PathVariable("first") int k) {
        return new ResponseEntity<>(personService.findPopular(k), HttpStatus.OK);
    }

    @GetMapping("/persons/unpopular/{first}")
    public ResponseEntity<List<Person>> getUnpopular(@PathVariable("first") int k) {
        return new ResponseEntity<>(personService.findUnpopular(k), HttpStatus.OK);
    }


    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        Person personData = personService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found Person with id = " + id));

            Person _person = personData;
            _person.setName(person.getName());

            return new ResponseEntity<>(personService.save(_person), HttpStatus.OK);

    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") long id) {
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
