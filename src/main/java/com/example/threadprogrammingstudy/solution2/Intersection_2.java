package com.example.threadprogrammingstudy.solution2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    synchronized 의 한계
    - 진입 및 탈출 자체에 비용이 소모된다
    - 세세한 Thread 컨트롤이 어렵다
 */
public class Intersection_2 {

    private Lock lockObject1 = new ReentrantLock();
    private Lock lockObject2 = new ReentrantLock();

    public void takeRoadA() {
        lockObject1.lock(); // 락킹 시작
        try{
            System.out.println("Road A is locked by thread : " + Thread.currentThread().getName());
            lockObject2.lock();
            try{
                System.out.println("  Train is passing through road A");
            } finally {
                lockObject2.unlock(); // 예외 발생하더라도 락을 풀어 deadLock 방지
            }
        } finally {
            lockObject1.unlock();
        }
    }

    public void takeRoadB() {
        lockObject2.lock();
        try{
            System.out.println("Road B is locked by thread : " + Thread.currentThread().getName());
            lockObject2.lock();
            try{
                System.out.println("  Train is passing through road B");
            } finally {
                lockObject2.unlock();
            }
        } finally {
            lockObject1.unlock();
        }
    }
}
