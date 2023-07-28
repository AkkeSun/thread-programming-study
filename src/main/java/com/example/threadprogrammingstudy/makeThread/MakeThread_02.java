package com.example.threadprogrammingstudy.makeThread;
/*
    Thread 상속을 통한 생성
 */
public class MakeThread_02 {

    public static void main(String[] args) {
        Thread myThread = new NewThread();
        Thread myThread2 = new Thread(new NewThread2());
        myThread2.setName("newThread2");

        System.out.println("Hello Main Thread");
        myThread2.start();
        myThread.start();
        System.out.println("Goodbye Main Thread");
    }

    public static class NewThread extends Thread {

        @Override
        public void run() {
            this.setName(this.getClass().getSimpleName()); // thread 이름을 클래스명으로 지정
            System.out.println("Hello from : " + Thread.currentThread().getName()); // 현재 클래스명 (newThread)
        }
    }

    public static class NewThread2 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("Hello from : " + Thread.currentThread().getName());
            } catch (InterruptedException ignored) {
            }
        }
    }

}
