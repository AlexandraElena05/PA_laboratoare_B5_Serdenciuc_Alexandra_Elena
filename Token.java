package com.company;

import java.util.Random;

public class Token {
    private int source;
    private int destination;
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Token(int source, int destination) {
        this.source = source;
        this.destination = destination;
        Random rand = new Random();
        this.value = rand.nextInt();
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
