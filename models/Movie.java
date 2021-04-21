package com.company.models;

import com.company.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Movie {
    String name;
    Director director;
    ArrayList<Actor> actors = new ArrayList<>();

    public Movie(String name){
        this.name = name;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setActors(ArrayList<Actor> actors){
        this.actors = actors;
    }

    public void addActor(Actor a){
        actors.add(a);
    }

    public ArrayList<Actor> getActors(){
        return actors;
    }

    public String getName(){
        return name;
    }

    public ResultSet getActors(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select p.name from persons p, movie_actors a, movies m" +
                     " where a.actor_id = p.id and m.id = a.movie_id and m.name like '" + name + "'")){
            return rs;
        }
    }
}
