package com.example.threadprogrammingstudy.solution2;

/*
    1. 순환 대기 예뱅하가 : 락킹 순서를 통일한다
    - 프로그램에 락킹이 별로 없는 경우 효과적이다
 */
public class MainClass {
    public static void main(String[] args) {
        Intersection_2 intersection = new Intersection_2();
        Thread trainAThread = new Thread(new TrainA_2(intersection));
        Thread trainBThread = new Thread(new TrainB_2(intersection));

        trainAThread.start();
        trainBThread.start();
    }
}
