package com.company;

import java.util.UUID;

public class Song extends Item{
    private String artist;
    private String album;

    public Song(String artist, String album, String name, String location) {
        super();
        this.artist = artist;
        this.album = album;
        this.setName(name);
        this.setLocation(location);
        this.setId(name);
    }


}
