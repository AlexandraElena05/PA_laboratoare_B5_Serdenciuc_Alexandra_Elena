package com.company;

public class TimeKeeper extends Thread{
    final long gameTime = 10 * (long) 1e9;

    @Override
    public void run(){
        long gameStartTime = System.nanoTime();
        while(true){
            if(System.nanoTime() - gameStartTime > gameTime){
                System.out.println("Time limit reached");
                System.exit(0);
            }
        }
    }

}
