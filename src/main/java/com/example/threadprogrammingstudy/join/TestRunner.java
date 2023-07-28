package com.example.threadprogrammingstudy.join;

public class TestRunner implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
                System.out.println("TestRunner run");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
