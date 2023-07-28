package com.example.threadprogrammingstudy.end.a_InterruptedException;

public class BlockingTask implements Runnable{

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(700);
                System.out.println("BlockingTask run");
            }
        } catch (InterruptedException e) {
            System.out.println("BlockingTask end");
        }
    }
}
