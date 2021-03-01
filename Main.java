package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Sourse> sourses = new ArrayList<Sourse>();
        sourses.add(new Factory("S1", 10));
        sourses.add(new Factory("S2", 35));
        sourses.add(new Warehouse("S3", 25));

        ArrayList<Destination> destinations = new ArrayList<Destination>();
        destinations.add(new Destination("D1", 10));
        destinations.add(new Destination("D2", 35));
        destinations.add(new Destination("D3", 25));

        int[][] matrix = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};

        var problem = new Problem(matrix, 3);
        try {
            problem.setSourses(sourses);
            problem.setDestinations(destinations);
            problem.PrintSolution();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
