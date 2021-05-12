package com.company.commands;

import com.company.ClientThread;
import com.company.Person;
import com.company.SocialNetwork;

import java.io.IOException;
import java.net.Socket;

public class LoginCommand implements Command{
    String[] args;

    public LoginCommand(String[] args)
    {
        this.args = args;
    }

    @Override
    public String execute(SocialNetwork network, Socket socket) throws IOException {
        String name;
        name = args[0];
        for(int i=0; i<network.getNetwork().size(); i++){
            if (network.getNetwork().get(i).getName().equalsIgnoreCase(name)){
                network.addLogin(new Person(name));
                ClientThread t = new ClientThread(socket);
                t.setName(name);
                t.start();
                System.out.println("New server-client client");
            }
            else{
                System.out.println("Person not registred");
            }
        }
        return "Person logged in";
    }
}
