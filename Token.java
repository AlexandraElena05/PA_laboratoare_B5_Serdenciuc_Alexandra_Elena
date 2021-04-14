package com.company;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return source == token.source && destination == token.destination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }

    @Override
    public String toString() {
        return "Token{" +
                +source + "," +
                destination +
                '}';
    }
}
