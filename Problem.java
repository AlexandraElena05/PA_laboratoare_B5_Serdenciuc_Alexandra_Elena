package com.company;

import java.util.ArrayList;

public class Problem {
    int [][] Matrix;
    int n;
    ArrayList<Sourse> sourses;
    ArrayList<Destination> destinations;

    public void PrintSolution() throws Exception {
        if(sourses == null)
            throw new Exception("Sourses must not be empty");
        if(destinations == null)
            throw new Exception("Destinations must not be empty");

        var solution = new Solution();

        int result = solution.solve(Matrix, n, sourses, destinations);

        System.out.println(result);
    }

    public void Print(){
        for(var i=0; i<n; i++) {
            for (var j = 0; j < n; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Sourse> getSourses() {
        return sourses;
    }

    public void setSourses(ArrayList<Sourse> sourses) throws Exception {
        for(int i=0; i<sourses.stream().count(); i++)
            for(int j=i+1; j<sourses.stream().count(); j++)
                if(sourses.get(i).equals(sourses.get(j)))
                    throw new Exception("Sourses must be unique");
        this.sourses = sourses;
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList<Destination> destinations) throws Exception {
        for(int i=0; i<destinations.stream().count(); i++)
            for(int j=i+1; j<destinations.stream().count(); j++)
                if(destinations.get(i).equals(destinations.get(j)))
                    throw new Exception("Destinations must be unique");
        this.destinations = destinations;
    }

    public Problem(int [][] matrix, int n) {
        this.n = n;
        Matrix = matrix;
        Print();
    }

    public int[][] getMatrix() {
        return Matrix;
    }

    public void setMatrix(int[][] matrix) {
        Matrix = matrix;
    }
}
