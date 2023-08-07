package com.example.threadprogrammingstudy.threadSafe;

import lombok.Getter;

/*
     synchronized method
      : 전체 method 임계지역으로 설정
      : threadA 가 increment() 에 진입한 경우 threadB 는 increment(), decrement() 모두에 접근이 불가능해진다
 */
@Getter
public class InventoryCounter {
    private int items = 0;

    public synchronized void increment(){
        items ++;
    }

    public synchronized void decrement(){
        items --;
    }


}
