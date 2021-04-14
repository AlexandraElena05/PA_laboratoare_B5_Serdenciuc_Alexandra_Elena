package com.company;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private Graph complete;

    public Graph getComplete() {
        return complete;
    }

    public Board() {
        List<Token> tokens = new LinkedList<>();
        for(int i=1; i<=10; i++){
            for(int j=1; j<=10; j++) {
                if (i == j) {
                    continue;
                }
                Token token = new Token(i, j);
                tokens.add(token);
            }
        }
        complete = new Graph(tokens);
    }
}
