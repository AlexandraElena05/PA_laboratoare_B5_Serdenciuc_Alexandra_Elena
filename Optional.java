package com.company;

public class Optional {
    public int [][] Matrix;
    public int [] Vis;

    public void DFS(int i, int n){
        Vis[i]=1;
        System.out.print(i + " ");
        for(var j=0; j<n; j++)
            if(Matrix[i][j]==1 && Vis[j]==0)
                DFS(j,n);
    }

    public int [][] CreatePartialGraph(int n){
        var partial = new int [n][n];
        for(var i=0; i<n; i++) {
            for (var j = 0; j < n; j++) {
                if (Matrix[i][j]==1) {
                    partial[i][j] = (int) (Math.random() * 2);
                    partial[j][i] = partial[i][j];
                }
                else
                {
                    partial[i][j]=0;
                    partial[j][i]=0;
                }
            }
        }
        return partial;
    }

    public void PrintMatrix(int [][] matrix, int n){
        if(n>30000) return;

        for(var i=0; i<n; i++) {
            for (var j = 0; j < n; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Optional(int n) {
        long startTime = System.nanoTime();
        Matrix = new int [n][n];

        for(var i=0; i<n; i++) {
            for (var j = 0; j < n; j++) {
                if (i == j) {
                    Matrix[i][j] = 0;
                }
                else {
                    Matrix[i][j] = (int) (Math.random() * 2);
                    Matrix[j][i] = Matrix[i][j];
                }
            }
        }
        PrintMatrix(Matrix,n);

        Vis = new int [n];
        int noConex=0;
        System.out.println("Componente conexe:");
        for(var i=0; i<n; i++){
            if(Vis[i]==0){
                noConex++;
                System.out.print(noConex + ":");
                DFS(i,n);
                System.out.println();
            }
        }

        if(noConex==1)
            System.out.println("Graf conex");
        else
            System.out.println("Graful nu este conex");

        var partialGraph = CreatePartialGraph(n);
        PrintMatrix(partialGraph,n);

        if(n>30000) {
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Duration: " + duration);
        }
    }
}
