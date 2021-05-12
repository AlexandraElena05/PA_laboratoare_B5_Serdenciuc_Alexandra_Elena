package com.company.commands;

import com.company.SocialNetwork;
import com.company.SocialNetworkServer;

import java.io.IOException;
import java.net.Socket;

public class SendCommand implements Command{
    String[] args;

    public SendCommand(String[] args)
    {
        this.args = args;
    }
    SocialNetworkServer server;

    @Override
    public String execute(SocialNetwork network, Socket socket) throws IOException {
        String message = args[0];

        network.getFriends().forEach(friend -> friend.messagesToRecieve.add(message));
        return "Message sent";
    }
}
