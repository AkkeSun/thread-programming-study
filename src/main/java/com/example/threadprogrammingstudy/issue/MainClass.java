package com.example.threadprogrammingstudy.issue;

/*
    데이터 경쟁
    컴파일러와 CPU가 성능 최적화와 하드웨어 활용을 위해 논리가 위배되지 않는 선에서 비순차적으로 명령을 처리하는 것
    이는 성능상 이점을 가져다 주지만 데이터 경쟁으로 의도한 응답값을 받지 못하는 경우 이를 막아주어야한다
 */
public class MainClass {

    public static void main(String[] args) {
        SharedClass sharedClass = new SharedClass();

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
