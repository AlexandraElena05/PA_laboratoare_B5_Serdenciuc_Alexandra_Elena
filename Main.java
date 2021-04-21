package com.company;

import com.company.DAO.GenreController;
import com.company.DAO.MovieController;
import com.company.DAO.PersonController;
import com.company.models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            PersonController persons = new PersonController();
            GenreController genre = new GenreController();
            MovieController movie = new MovieController();
            ImportData dataImporter = new ImportData();
            genre.create("action");
            movie.create("Jump", genre.findByName("action"));


            Director director1 = new Director("Francis Ford Coppola", 1);
            Actor actor1 = new Actor("Al Pacino");
            Actor actor2 = new Actor("Marlon Brando");
            Movie movie1 = new Movie("The godfather");
            movie1.setDirector(director1);
            movie1.addActor(actor1);
            movie1.addActor(actor2);

            String fileName = "c:\\test\\csv\\country.csv";
            dataImporter.importData(fileName);

            //persons.create("Francis Ford Coppola");
            persons.create(director1.getName());
            persons.create(actor2.getName());
            persons.create(actor1.getName());


            System.out.println(movie.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
