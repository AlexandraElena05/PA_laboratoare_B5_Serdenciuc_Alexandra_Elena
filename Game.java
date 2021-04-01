package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private final List<Player> players = new ArrayList<>();
    private Player winner;

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    //Create getters and setters

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }



    public void setWinner(Player player) {
        this.winner = player;
    }

    public void start() {
        players.forEach(player -> {
            Thread newThread = new Thread(player);
            newThread.start();
        });
    }

    public Player getWinner() {
        return winner;
    }
}
