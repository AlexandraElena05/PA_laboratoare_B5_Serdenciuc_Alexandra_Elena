package com.company.commands;

import com.company.SocialNetwork;

import java.io.IOException;
import java.net.Socket;

public class ReadCommand implements Command{
    String[] args;

    public ReadCommand(String[] args)
    {
        this.args = args;
    }

    @Override
    public String execute(SocialNetwork network, Socket socket) throws IOException {
        StringBuilder messages = new StringBuilder();
        network.getFriends().forEach(friend -> {
            messages.append(friend.messagesToRecieve.peek());
            messages.append("\n");
            friend.messagesToRecieve.remove();
        });
        return messages.toString();
    }

}
