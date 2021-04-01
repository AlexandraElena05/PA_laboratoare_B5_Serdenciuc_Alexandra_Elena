package com.company;

import java.util.PrimitiveIterator;

public class Player implements Runnable{
    private String name;
    private Game game;
    private Graph graph;

    public Player(String s, Game game) {
        this.name = s;
        this.game = game;
        this.graph = game.getBoard().getComplete();
    }

    public Player(String name, Game game, Graph graph) {
        this.name = name;
        this.game = game;
        this.graph = graph;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    private boolean play() throws InterruptedException {
        Board board = game.getBoard();
        while(true) {
            if (board.isEmpty()) {
                return true;
            }
            var t = board.extract();
            graph.addToken(t);
            System.out.println(this.name + " extracted token with value " + t.getValue());
            Thread.sleep(THINKING_TIME); //declare this constant
        }
    }

    public void run() {
        try {
            play();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    private final static int THINKING_TIME = 2000;


}
