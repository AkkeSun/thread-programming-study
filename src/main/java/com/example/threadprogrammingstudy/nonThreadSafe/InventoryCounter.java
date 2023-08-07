package com.example.threadprogrammingstudy.nonThreadSafe;

import lombok.Getter;

/*
    increment(), decrement() 를 다른 Thread 로 실행하는 경우
    STEP 3 (items = newVal) 실행 순서에 따라 결과값이 재정의 되어 의도한 값이 나오지 않을 수 있다.
    [실행순서 예제]
    - increment 1
    - increment 2
    - decrement 1
    - decrement 2
    - increment 3
    - decrement 3 -> increment 실행 로직과 상관없이 최종 items 값은 decrement 3 으로 초기화되어 버린다
 */
@Getter
public class InventoryCounter {
    private int items = 0;

    /*
        1. items 값 로드
        2. newVal = items + 1
        3. items = newVal
     */
    public void increment(){
        items ++;
    }

    /*
    1. items 값 로드
    2. newVal = items - 1
    3. items = newVal
    */
    public void decrement(){
        items --;
    }
}
