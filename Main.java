package com.company;

public class Main {

    public static void main(String[] args) {

        int [][] Matrix = new int [4][4];

        Matrix[0][0]=2; Matrix[0][1]=3; Matrix[0][2]=1; Matrix[0][3]=10;
        Matrix[1][0]=5; Matrix[1][1]=4; Matrix[1][2]=8; Matrix[1][3]=35;
        Matrix[2][0]=5; Matrix[2][1]=6; Matrix[2][2]=8; Matrix[2][3]=25;
        Matrix[3][0]=20; Matrix[3][1]=25; Matrix[3][2]=25; Matrix[3][3]=0;
        var example = new Problem(Matrix, 4);

    }
}
