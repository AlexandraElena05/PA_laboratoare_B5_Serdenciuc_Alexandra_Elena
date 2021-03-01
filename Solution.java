package com.company;

import java.util.ArrayList;

public class Solution {
    public int solve (int [][] matrix, int n, ArrayList<Sourse> s, ArrayList<Destination> d){
        int sum=0;
        while (!ShouldStop(s,d)) {
            var find = findMin(matrix, n, s, d);

            var currentSourse = s.get(find[0]);
            var currentDestination = d.get(find[1]);

            System.out.print(currentSourse + "->" + currentDestination + ":");

            int commoditiesS = currentSourse.getCommodities();
            int commoditiesD = currentDestination.getCommodities();

            int moved = Math.min(commoditiesS,commoditiesD);

            currentSourse.setCommodities(commoditiesS-moved);
            currentDestination.setCommodities(commoditiesD-moved);

            sum = sum + moved * matrix[find[0]][find[1]];
            System.out.println(sum);
        }
        return sum;
    }

    public int[] findMin(int [][] matrix, int n, ArrayList<Sourse> s, ArrayList<Destination> d){
        int min=999999999;
        int [] ret =  new int [2];
        for(var i=0; i<n; i++)
            for(var j=0; j<n; j++){
                if (s.get(i).getCommodities()>0 && d.get(j).getCommodities()>0 && matrix[i][j]<min) {
                   min=matrix[i][j];
                   ret[0]=i;
                   ret[1]=j;
                }
            }
        return ret;
    }

    public boolean ShouldStop(ArrayList<Sourse> s, ArrayList<Destination> d){
        int avaS=0;
        int avaD=0;
        for (var sourse:s) {
            if(sourse.getCommodities()>0)
                avaS++;
        }

        for (var destination:d) {
            if(destination.getCommodities()>0)
                avaD++;
        }

        if(avaS>0 && avaD>0)
            return false;

        return true;
    }

}
