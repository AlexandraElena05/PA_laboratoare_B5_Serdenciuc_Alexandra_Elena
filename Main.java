package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello world!");
        String[] stringArray = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        //randomNum = minimum + (int)(Math.random() * maximum);
        int n = (int) (Math.random() * 1_000_000);
        n = n * 2;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        System.out.println(n);
        int cop=n;
        int sum=0;
        int ok=0;
        int sum1=n;
        while (sum1 > 9) {
            if(ok==0)
            while (cop > 0){
                    sum = sum + cop % 10;
                    cop = cop / 10; ok=1;
            }
            else
                {
                while(sum1>0)
                {sum = sum + sum1 % 10;
                 sum1 = sum1 / 10;
                }

            }
            sum1=sum;
        }

        System.out.println("Willy-nilly, this semester I will learn " + System.getProperty(sum1));
    }
}
