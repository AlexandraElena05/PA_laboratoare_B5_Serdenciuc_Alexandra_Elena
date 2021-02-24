package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello world!");
        var languages = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        //randomNum = minimum + (int)(Math.random() * maximum);
        int n = (int) (Math.random() * 1_000_000);
        n = n * 2;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        System.out.println(n);
        int sum1=0;
        while(n!=0)
        {
            sum1=sum1+n%10;
            n=n/10;
            if(n==0 && sum1>=10)
                {n=sum1; sum1=0;}

        }
        System.out.println(sum1);

        System.out.println("Willy-nilly, this semester I will learn " + languages[sum1]);
    }
}
