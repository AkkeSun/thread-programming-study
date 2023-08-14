package com.example.threadprogrammingstudy.solution1;

/*
    락킹 순서를 동일하게 한다
 */
public class Intersection_1 {

    private Object roadA = new Object();
    private Object roadB = new Object();

    public void takeRoadA(){
        synchronized (roadA){
            System.out.println("Road A is locked by thread : " + Thread.currentThread().getName());
            synchronized (roadB){
                System.out.println("  Train is passing through road A");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void takeRoadB(){
        synchronized (roadA){
            System.out.println("Road B is locked by thread : " + Thread.currentThread().getName());
            synchronized (roadB){
                System.out.println("  Train is passing through road B");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
