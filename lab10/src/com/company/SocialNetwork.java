package com.company;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class SocialNetwork {

    private Socket socket = null;
    private ArrayList<Person> registered = new ArrayList<>();
    private ArrayList<Person> login = new ArrayList<>();
    private ArrayList<Person> myFriends = new ArrayList<>();

    SocialNetwork(Socket socket) {
        this.socket = socket;
    }

    ArrayList<Person> getNetwork() {
        return registered;
    }

    void addRegistration(Person p){
        registered.add(p);
    }

    void addLogin(Person p){
        login.add(p);
    }

    void addFriends(Person p){
        myFriends.add(p);
    }

    ArrayList<Person> getFriends(){
        return myFriends;
    }


    public String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
