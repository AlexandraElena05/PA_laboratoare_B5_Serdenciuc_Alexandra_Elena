package com.company.commands;

import com.company.SocialNetwork;

import java.net.Socket;

public class DefaultCommand implements Command{

    public DefaultCommand() {
    }

    @Override
    public String execute(SocialNetwork network, Socket socket) {
        return "Server received the request";
    }
}
