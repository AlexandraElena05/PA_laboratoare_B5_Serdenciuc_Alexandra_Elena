package com.company;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    List<Token> Tokens = new LinkedList<>();

    public Graph(List<Token> Tokens) {
        this.Tokens = Tokens;
    }

    public List<Token> getTokens() {
        return Tokens;
    }

    public Token pullFirst() {

        Token Token = Tokens.get(0);
        Tokens.remove(0);
        return Token;
    }

    public void setTokens(List<Token> Tokens) {
        this.Tokens = Tokens;
    }

    public void addToken(Token Token) {
        Tokens.add(Token);
    }


    public boolean isEmpty() {
        return Tokens.isEmpty();
    }
}
