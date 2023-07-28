package com.example.threadprogrammingstudy.end.a_InterruptedException;
/*
    thread.interrupt()
    특정 조건 부합시 InterruptedException 을 발생시켜 thread 를 종료시킨다
 */
public class MainClass {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread Start");
        Thread thread = new Thread(new BlockingTask());
        thread.start();

        for(int i =0; i<15; i++) {
            Thread.sleep(500);
            System.out.println(i);
            if(i == 10) {
                thread.interrupt();
            }
        }
        System.out.println("Main Thread End");
    }
}
