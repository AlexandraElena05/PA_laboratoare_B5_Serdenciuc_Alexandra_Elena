package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private final List<Player> playerList = new ArrayList<>();
    private String winner;
    private String playerName;
    private int winingScore=0;
    private int players;

    public int getPlayers() {
        return players;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String player) {
        this.playerName = player;
    }

    public int getWiningScore() {
        return winingScore;
    }

    public void setWiningScore(int winingScore) {
        this.winingScore = winingScore;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        playerList.add(player);
        player.setGame(this);
    }
    //Create getters and setters

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public synchronized void playerTurn(Player player){
        while (!player.getName().equals(this.playerName)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        player.selectPiece();
        this.playerName = playerList.get((playerList.indexOf(player) + 1) % playerList.size()).getName();
        notifyAll();
    }

    public void play(){
        TimeKeeper tk = new TimeKeeper();
        tk.setDaemon(true);
        tk.start();
        playerName = playerList.get(0).getName();
        List<Thread> threadList = new ArrayList<>();
        for(var player : playerList ){
                threadList.add(new Thread(player));
                threadList.get(threadList.size()-1).start();
        }
        for(var thread : threadList){
            try{
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        playerList.sort((p1,p2)->Integer.compare(p1.getInputNumber(),p2.getInputNumber()));
        for(Player player : playerList){
            System.out.println(player.getName() + " scored " + player.getInputNumber());
        }

        if(playerList.get(0).getInputNumber()==playerList.get(1).getInputNumber())
            System.out.println("It's a tie!");
        else
            System.out.println("The winner is " + playerList.get(0).getName());
    }

}
