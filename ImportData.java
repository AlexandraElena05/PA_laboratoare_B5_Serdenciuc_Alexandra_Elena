package com.company;

import com.company.DAO.GenreController;
import com.company.DAO.MovieController;
import com.company.DAO.PersonController;
import com.company.models.Person;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ImportData {

    private MovieController mc = new MovieController();
    private PersonController pc = new PersonController();
    private GenreController gc = new GenreController();

    public void importData(String location){

        try (CSVReader reader = new CSVReader(new FileReader(location))) {

            List<String[]> r = reader.readAll();
            r.forEach(x -> {
                try {
                    addToDb(x);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }

    private void addToDb(String[] x) throws SQLException {
        if(gc.findByName(x[5])==null) {
            gc.create(x[5]);} //daca nu exista categoria, o cream (x[5] reprezinta a 6-a coloana din csv)
            mc.create(x[1], gc.findByName(x[5]));
            pc.create(x[9]);
            var actors = x[12].replace("\"", "").split(","); //luam toti actorii de pe coloana 13
        for (String actor:actors) {
            pc.create(actor);
        }
        }
}
