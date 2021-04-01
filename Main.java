package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.setBoard(new Board(3));
        game.addPlayer(new Player("Player 1",game));
        game.addPlayer(new Player("Player 2",game));

        game.start();
    }
}
