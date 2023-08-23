package com.example.threadprogrammingstudy.libraryExample;

public class Library {

    private final int MAX_CNT = 5;
    private int nowCnt = 0;

    public synchronized boolean studyStart() {
        Thread thread = Thread.currentThread();
        if (nowCnt == MAX_CNT) {
            try {
                System.out.println("wait -- " + thread.getName());
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("study start -- " + thread.getName());
        nowCnt ++;
        return true;
    }

    public synchronized void studyEnd()  {
        Thread thread = Thread.currentThread();
        System.out.println("    study end -- " + thread.getName());
        nowCnt --;
        this.notify();
    }

}
