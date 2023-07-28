package com.example.threadprogrammingstudy.makeThread;

/*
   main thread 가 “Program start : main “ 를 프린트합니다.
   myThread 가 스케쥴링 됩니다
   스케쥴링 시간이 “ Program end : main”을 프린트하는 시간보다 짧다면 myThread 결과가 먼저 프린트 됩니다.
   스케쥴링 시간이 “ Program end : main”을 프린트하는 시간보다 길다면 아래와 같이 프린트 됩니다

   Program start : main
   Program end : main
   Custom Thread Start : new Thread
   Custom Thread Priority : 10
   Custom Thread Exception - new Thread : 예외 발생
   */
public class MakeThread_01 {

    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread 가 실행할 work
                System.out.println("Custom Thread Start : " + Thread.currentThread().getName());
                System.out.println("Custom Thread Priority : " + Thread.currentThread().getPriority());
                throw new RuntimeException("예외 발생");
            }
        });

        myThread.setName("new Thread"); // thread 이름 설정
        myThread.setPriority(Thread.MAX_PRIORITY); // thread 실행 우선순위 설정 (1 ~ 10)
        // thread 에서 발생한 예외 처리
        myThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Custom Thread Exception - " + t.getName() + " : " + e.getMessage());
            }
        });


        System.out.println("Program start : " + Thread.currentThread().getName());
        myThread.start(); // thread  실행
        System.out.println("Program end : " + Thread.currentThread().getName());

    }
}
