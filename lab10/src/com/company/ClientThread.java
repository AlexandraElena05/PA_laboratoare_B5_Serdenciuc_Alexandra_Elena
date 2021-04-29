package com.company;

import com.company.commands.Command;
import com.company.commands.CommandBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    private SocialNetworkServer server;
    private SocialNetwork net = new SocialNetwork(socket);

    ClientThread (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                System.out.println("\r\nMessage from " + Thread.currentThread().getName() + ": " + request);
                String response = execute(request);
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(response);

                out.flush();

                if (request.equalsIgnoreCase("stop")) {
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private String execute(String request) {
        String response;
        response = null;
        if (request.equalsIgnoreCase("stop")) {
            response = "Server stopped!";
        } else {
            response = "Server received the request " + request;
        }
        return response;
    }
}
