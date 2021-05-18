package com.example.lab11.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "public")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    public List<Long> getFriends() {
        return friends;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "list_of_friends", joinColumns = @JoinColumn(name = "person_id"))
    private List<Long> friends = new ArrayList<Long>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void addFriend(Long id){
        friends.add(id);
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }

}
