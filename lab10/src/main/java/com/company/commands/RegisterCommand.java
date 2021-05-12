package com.company.commands;

import com.company.Person;
import com.company.SocialNetwork;

import java.io.IOException;
import java.net.Socket;

public class RegisterCommand implements Command{
    String[] args;


    public RegisterCommand(String[] args)
    {
        this.args = args;
    }

    @Override
    public String execute(SocialNetwork network, Socket socket) throws IOException {
        String name;
        name = args[0];
        network.addRegistration(new Person(name));
        return "Person registered";
    }
}
