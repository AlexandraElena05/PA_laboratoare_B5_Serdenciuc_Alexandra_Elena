package com.company.commands;

import com.company.SocialNetwork;

import java.io.IOException;
import java.net.Socket;

public class StopCommand implements Command{

    public StopCommand() {
    }

    @Override
    public String execute(SocialNetwork network, Socket socket) {
        return "Server stopped";
    }
}
