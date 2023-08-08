package com.example.threadprogrammingstudy.issue;

public class SharedClass {

    private int x = 0;
    private int y = 0;

    // CPU 입장에서는 x++ 와 y++ 사이에 의존관계가 없기 때문에 x++ 와 y++ 를 같은 연산으로 판단하고 순서를 버꿔 실행하기도 한다
    public void increment(){
        x ++;
        y ++;
    }

    // 예상대로라면 해당 메시지가 출력되지 않아야하지만 데이터 경쟁으로 인해 해당 메시지가 출력된다
    public void checkForDataRace(){
        if(y > x){
            System.out.println("Data Race is detected");
        }
    }
}
