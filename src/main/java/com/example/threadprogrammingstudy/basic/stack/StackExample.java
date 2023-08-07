package com.example.threadprogrammingstudy.basic.stack;

/*
    Stack Frame : 매소드 호출 시 저장되는 임시저장공간
    args = null 저장
    x = 10 저장
    y = 20 저장
    sum 함수의 매개변수 (x,y) 저장
    sum 함수의 리턴값 저장
      sum 함수의 리턴값 삭제
      sum 함수의 매개변수 (x,y) 삭제
    sum = 30 저장
       sum = 30 삭제
       y = 20 삭제
       x = 10 삭제
       args = null 삭제
 */
public class StackExample {

    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int sum = sum(x, y);
        System.out.println(sum);
    }

    public static int sum(int x, int y){
        return x + y;
    }
}
