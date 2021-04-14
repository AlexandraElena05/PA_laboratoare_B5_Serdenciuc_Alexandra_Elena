package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player implements Runnable{
    private String name;
    private Game game;
    private List<Token> inputTokens = new ArrayList<>();

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    private int inputNumber;

    public Player(String s) {
        this.name = s;
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

    public boolean checkIfHuman(){
        if(game.getPlayerList().indexOf(this) < game.getPlayers())
            return true;
        return false;
    }

    public void selectPiece() {
        if (!game.getBoard().getComplete().isEmpty()) {
            if (checkIfHuman()) {
                int firstValue, secondValue;
                boolean taskSuccesful = false;
                System.out.println( name + " input a piece: (first value, second value, separated by space)");
                Scanner keyboard = new Scanner(System.in);
                while (!taskSuccesful) {
                    firstValue = keyboard.nextInt();
                    secondValue = keyboard.nextInt();
                    Token givenToken = new Token(firstValue, secondValue);
                    if (game.getBoard().getComplete().getTokens().contains(givenToken)) {
                        inputTokens.add(givenToken);
                        game.getBoard().getComplete().getTokens().remove(givenToken);
                        taskSuccesful = true;
                        inputNumber += firstValue;
                        inputNumber += secondValue;
                    } else
                        System.out.println("Invalid token");
                }
            } else {
                int pieceIndex = ThreadLocalRandom.current().nextInt(0, game.getBoard().getComplete().getTokens().size());
                inputTokens.add(game.getBoard().getComplete().getTokens().get(pieceIndex));
                inputNumber+=game.getBoard().getComplete().getTokens().get(pieceIndex).getSource();
                inputNumber+=game.getBoard().getComplete().getTokens().get(pieceIndex).getDestination();
                game.getBoard().getComplete().getTokens().remove(pieceIndex);
                System.out.println(name + " removed piece " + inputTokens.get(inputTokens.size() - 1));
            }
        }

    }

    @Override
    public void run() {
        while (!game.getBoard().getComplete().isEmpty()){
            game.playerTurn(this);
        }
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

}
