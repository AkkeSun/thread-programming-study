package com.example.threadprogrammingstudy.basic.method;

/*
    Method (Static) 영역 : JVN 실행시 할당되는 영역
    객채를 정의하는데 필요하는 필드 정보 (클래스 멤버변수, 데이터 타입, 메소드 이름, 리턴타입, 파라미터 타입 등)와 Static 객채 및 변수가 이에 해당된다
    어디서나 사용이 가능하고 프로그램이 종료될 때 까지 메모리에 남아있다

    s = 10
    MainClass
     - void main(String[] args)
     - void twice(Counter c)
    Counter
     - int get()
     - void plus(int n)
 */

public class MainClass {
    public static int s = 10;

    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int result1 = a + b + MainClass.s;
        System.out.println(result1);

        Counter sub = new Counter();
        twice(sub);
        int result2 = sub.get();
        System.out.println(result2);
    }

    public static void twice(Counter c) {
        c.plus(10);
        c.plus(20);
    }
}

class Counter {

    public int state = 50;
    public final int count = 20;

    public int get() {
        return state + count;
    }

    public void plus(int n) {
        state += n;
    }
}