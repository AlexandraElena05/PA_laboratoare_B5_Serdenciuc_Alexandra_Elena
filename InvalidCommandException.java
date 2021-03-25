package com.company;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(Exception ex) {
        super("Invalid command.", ex);
    }
}
