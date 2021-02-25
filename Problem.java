package com.company;

import java.util.Arrays;

public class Problem {
    public int [][] Matrix;

    public void Print(int [][] matrix, int n){
        for(var i=0; i<n; i++) {
            for (var j = 0; j < n; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Problem() {
        Matrix = null;
    }

    public Problem(int [][] matrix, int n) {
        Matrix = matrix;
        Print(Matrix, n);
    }

    public int[][] getMatrix() {
        return Matrix;
    }

    public void setMatrix(int[][] matrix) {
        Matrix = matrix;
    }
}
