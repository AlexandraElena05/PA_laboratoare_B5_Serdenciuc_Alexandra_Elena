package com.company;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Board board = new Board();
        int players;
        System.out.println("Enter human player numbers:");
        Scanner input = new Scanner(System.in);
        players = input.nextInt();
        game.setPlayers(players);
        IntStream.rangeClosed(1,100).mapToObj(i -> new Player("player" + i)).forEach(game::addPlayer);
        game.setBoard(board);

        game.play();
    }
}
