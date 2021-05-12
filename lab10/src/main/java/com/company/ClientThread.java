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

    public ClientThread (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            boolean threadOpen = true;
            while (threadOpen) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                System.out.println("\r\nMessage from " + Thread.currentThread().getName() + ": " + request);
                String response = execute(request);
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                if(request.equalsIgnoreCase("stop")){
                    threadOpen = false;
                }
                out.println(response);

                out.flush();
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

    private String execute(String request) throws IOException {
        String response;
        response = null;
        CommandBuilder commandBuilder = new CommandBuilder();
        Command command;
        if (request.equalsIgnoreCase("stop")) {
            System.out.println("Server received the request " + request);
            command = commandBuilder.CommandBuilder(request);
            response = command.execute(net, socket);
            SocialNetworkServer.running = false;
            System.out.println(SocialNetworkServer.running);
        } else {
            System.out.println("Server received the request " + request);
            command = commandBuilder.CommandBuilder(request);
            response = command.execute(net, socket);
        }
        return response;
    }
}
