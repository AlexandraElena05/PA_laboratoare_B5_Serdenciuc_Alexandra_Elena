package com.company.commands;

import java.util.Arrays;

public class CommandBuilder {
    public Command CommandBuilder (String request){
        String command;
        String[] args;
        String[] parts = request.split(" ");
        command = parts[0];
        args = Arrays.copyOfRange(parts,1,parts.length);
        switch (command)
        {
            case "stop":
                return new StopCommand();
        }
        return new DefaultCommand();
    }
}
