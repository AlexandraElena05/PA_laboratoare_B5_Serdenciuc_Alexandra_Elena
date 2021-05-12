package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocialNetworkServer {

    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    public static boolean running = false;
    Map<String, Socket> sockets = new HashMap<String, Socket>();
    static String userName;


    public SocialNetworkServer(String userName){
        ServerSocket serverSocket= null;
        this.userName = userName;
    }

    public static void main(String[] args) {
	// write your code here
        SocialNetworkServer server = new SocialNetworkServer(userName);
        server.init();
        server.waitClients();

    }

    public void init(){
        try{
            running = true;
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitClients(){
        try{
            System.out.println("Waiting for clients...");
            while(running){
                Socket socket = serverSocket.accept();
                ClientThread t = new ClientThread(socket);
                String userName = getUserName(socket);
                sockets.put(userName, socket);
                t.start();
            }
            System.out.println("Server stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getUserName(Socket socket){
        return userName;
    }

    public ServerSocket getServerSocket(){
        return serverSocket;
    }

    public Map<String, Socket> getSockets(){
        return sockets;
    }

    public void stop(){
        this.running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
