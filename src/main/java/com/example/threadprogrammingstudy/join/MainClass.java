package com.example.threadprogrammingstudy.join;

/*
    Join
    Custom Thread 를 일정 시간 실행시킨 후 main thread 가 실행하도록 처리
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread Start");
        Thread thread = new Thread(new TestRunner());
        thread.setDaemon(true);
        thread.start();
        // thread 실행 시간이 3초가 넘은 후에 main thread 가 실행되도록 설정
        thread.join(3000); ; // 파라미터값을 입력하지 모든 thread 가 실행완료 될 때 까지 기다림
        for(int i = 0 ; i <= 10 ; i ++) {
            Thread.sleep(100);
            System.out.println(i);
        }
    }
}
