package com.company.commands;

import com.company.SocialNetwork;

import java.net.Socket;

public interface Command {
    String execute(SocialNetwork network, Socket socket);
}
