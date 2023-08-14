package com.example.threadprogrammingstudy.solution1;

/*
    1. 순환 대기 예뱅하가 : 락킹 순서를 통일한다
    - 프로그램에 락킹이 별로 없는 경우 효과적이다
 */
public class MainClass {
    public static void main(String[] args) {
        Intersection_1 intersection = new Intersection_1();
        Thread trainAThread = new Thread(new TrainA_1(intersection));
        Thread trainBThread = new Thread(new TrainB_1(intersection));

        trainAThread.start();
        trainBThread.start();
    }
}
