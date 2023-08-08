package com.example.threadprogrammingstudy.solution;

public class SharedClass2 {

    // volatile : 잠금 오버헤드를 줄이고 처리 순서를 보장한다 (성능은 떨어진다)
    private volatile int x = 0;
    private volatile int y = 0;

    public void increment(){
        x ++;
        y ++;
    }

    public void checkForDataRace(){
        if(y > x){
            System.out.println("Data Race is detected");
        }
    }
}
