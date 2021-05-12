package com.company.commands;

import com.company.Person;
import com.company.SocialNetwork;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class FriendCommand implements Command{
    String[] args;

    public FriendCommand(String[] args)
    {
        this.args = args;
    }

    @Override
    public String execute(SocialNetwork network, Socket socket) throws IOException {
        ArrayList<String> names = new ArrayList<>();
        for (String arg: args){
            Person p = new Person(arg);
            network.addFriends(p);
        }

        return "Friends added";
    }
}
