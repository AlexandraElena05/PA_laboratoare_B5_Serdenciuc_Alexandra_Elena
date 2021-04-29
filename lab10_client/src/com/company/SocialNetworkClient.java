package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocialNetworkClient {

    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    private Socket socket;

    public static void main(String[] args) throws IOException {
        SocialNetworkClient client = new SocialNetworkClient();
        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else {
                try {
                    client.sendRequestToServer(request);
                }
                catch (SocketException se){
                    System.out.println("Server shut down successfully!");
                    System.exit(0);
                }
            }
        }
    }

    //Implement the sendRequestToServer method
    private String sendRequestToServer(String request) throws IOException {
        socket = new Socket(SERVER_ADDRESS, PORT);
        String resp = "";
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // send the request to the server:
            out.println(request);
            // read the response from the server:
            String response = in.readLine();
            System.out.println(response);
        } catch (UnknownHostException e) {
            System.err.println(e);
        }
        return resp;
    }

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
