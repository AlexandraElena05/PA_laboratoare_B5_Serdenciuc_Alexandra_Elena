package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Person {

    private String name;
    Queue<String> messagesToRecieve = new LinkedList<>();

    Person(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue<String> getMessagesToRecieve() {
        return messagesToRecieve;
    }

    public void setMessagesToRecieve(Queue<String> messagesToRecieve) {
        this.messagesToRecieve = messagesToRecieve;
    }
}
