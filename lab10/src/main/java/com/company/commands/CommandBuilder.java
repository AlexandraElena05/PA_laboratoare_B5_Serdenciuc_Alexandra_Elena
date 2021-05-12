package com.company.commands;

import java.util.Arrays;

public class CommandBuilder {
    public Command CommandBuilder (String request){
        String command;
        String[] args;
        String[] parts = request.split(" ");
        command = parts[0];
        args = Arrays.copyOfRange(parts,1,parts.length);

        if(command.equals("register"))
        {
            return new RegisterCommand(args);
        }

        if(command.equals("login"))
        {
            return new LoginCommand(args);
        }

        if(command.equals("friend"))
        {
            return new FriendCommand(args);
        }

        if(command.equals("send"))
        {
            return new SendCommand(args);
        }
        // stop app
        if(command.equals("stop"))
        {
            return new StopCommand();
        }

        if(command.equals("read"))
        {
            return new ReadCommand(args);
        }
        return new DefaultCommand();
    }
}
