package com.company.models;

import com.company.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Actor extends Person{

    ArrayList<Movie> moviesStarred = new ArrayList<>();
    public Actor(String name){
        this.name = name;
    }

    public void addMovie(Movie m){
        moviesStarred.add(m);
    }

    public String getMovieStarred(String movieStarred) {
        return movieStarred;
    }

    public ResultSet getMovies(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select m.name from persons p, movie_actors a, movies m" +
                     " where a.actor_id = p.id and m.id = a.movie_id and p.name like '" + name + "'")){
            return rs;
        }
    }
}
