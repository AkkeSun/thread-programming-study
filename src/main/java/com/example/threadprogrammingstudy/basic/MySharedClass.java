package com.example.threadprogrammingstudy.basic;

public class MySharedClass {

    private boolean isComplete = false;
    private int num = 0;

    public synchronized void waitUntilComplete() {
        while (!isComplete) {
            try {
                System.out.println("기다리는 중입니다");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("일어났습니다 -- result : " + num);
        }
    }

    public synchronized void complate() {
        while (num < 20) {
            try {
                Thread.sleep(500);
                num ++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isComplete = true;
        this.notify();
    }
}
