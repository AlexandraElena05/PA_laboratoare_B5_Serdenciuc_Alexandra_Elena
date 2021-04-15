package com.company;

import com.company.DAO.GenreController;
import com.company.DAO.MovieController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            GenreController genre = new GenreController();
            MovieController movie = new MovieController();
            genre.create("action");
            movie.create("Jump", genre.findByName("action"));
            System.out.println(movie.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
