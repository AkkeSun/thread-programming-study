package com.example.threadprogrammingstudy.threadSafe;

import lombok.Getter;

/*
     synchronized block (Object) -> 추천
      : 특정 블록을 임계영역으로 설정
      : increment() 가 lock1 을 입력받고, decrement() 가 lock2 를 입력받는 경우
        threadA 가 increment() 에 진입하였을 때 threadB 는 increment() 에만 접근이 불가능하고 decrement() 에는 접근이 가능하다
 */
@Getter
public class InventoryCounter2 {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private int items = 0;

    public void increment(){
        synchronized (lock1){
            items ++ ;
        }
    }

    public void decrement(){
        synchronized (lock1){
            items -- ;
        }
    }
}
