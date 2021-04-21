package com.company.models;

import com.company.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Director extends Person{
    int directorId;
    ArrayList<Movie> moviesDirected = new ArrayList<>();
    public Director(String name, int directorId){
        this.name = name;
        this.directorId = directorId;
    }

    public ArrayList<Movie> getMovie(){
        return moviesDirected;
    }

    public void addMovie(Movie m){
        moviesDirected.add(m);
    }

    public int getId(){
        return directorId;
    }

    public ResultSet getMovies(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select m.name from persons p, movies m" +
                     " where m.director_id = p.id and p.name like '" + name + "'")){
            return rs;
        }
    }

}
