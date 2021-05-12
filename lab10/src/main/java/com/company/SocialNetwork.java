package com.company;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class SocialNetwork {

    private Socket socket = null;
    private ArrayList<Person> registered = new ArrayList<>();
    private ArrayList<Person> login = new ArrayList<>();
    private ArrayList<Person> myFriends = new ArrayList<>();

    public SocialNetwork(Socket socket) {
        this.socket = socket;
    }

    public ArrayList<Person> getNetwork() {
        return registered;
    }

    public void addRegistration(Person p){
        registered.add(p);
    }

    public void addLogin(Person p){
        login.add(p);
    }

    public void addFriends(Person p){
        myFriends.add(p);
    }

    public ArrayList<Person> getFriends(){
        return myFriends;
    }


    public String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
