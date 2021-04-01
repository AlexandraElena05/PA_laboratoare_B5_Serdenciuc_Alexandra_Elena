package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private Graph complete;

    public Graph getComplete() {
        return complete;
    }

    public Board(int n) {
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                tokens.add(new Token(i, j));
            }
        }

        Collections.shuffle(tokens);
        complete = new Graph(tokens);
    }

    public synchronized Token extract(){
       Token token = complete.pullFirst();
       return token;
    }

    public Boolean isEmpty(){
        return complete.isEmpty();
    }
}
