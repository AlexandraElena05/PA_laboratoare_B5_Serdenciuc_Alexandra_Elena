package com.company;

import java.util.UUID;

public class Book extends Item{
    private String autor;
    private String editura;

    public Book(String autor, String editura, String name, String location) {
        super();
        this.autor = autor;
        this.editura = editura;
        this.setName(name);
        this.setLocation(location);
        this.setId(name);
    }
}
