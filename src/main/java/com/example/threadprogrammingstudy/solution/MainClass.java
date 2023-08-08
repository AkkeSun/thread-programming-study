package com.example.threadprogrammingstudy.solution;

public class MainClass {

    public static void main(String[] args) {
        SharedClass2 sharedClass = new SharedClass2();

        Thread thread1 = new Thread(() -> {
            for(int i =0; i<Integer.MAX_VALUE; i++){
                sharedClass.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i =0; i<Integer.MAX_VALUE; i++){
                sharedClass.checkForDataRace();
            }
        });
        thread1.start();
        thread2.start();
    }
}
