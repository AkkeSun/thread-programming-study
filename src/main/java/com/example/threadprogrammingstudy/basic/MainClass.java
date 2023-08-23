package com.example.threadprogrammingstudy.basic;
/*
    사용 조건 : 같은 Lock 이 걸려있는 동기화 함수 (synchronized)
    A 로직을 분산 처리하고 B 로직을 통합 처리하는 등의 솔루션에 유용하다

    wait() : 다른 쓰레드가 깨어날때까지 현재 쓰레드를 기다리게 한다
    notify() : 현재 객채에서 대기하는 단일 쓰레드를 꺠운다
    notifyAll() : 객채의 모든 쓰레들르 깨운다
 */
public class MainClass {

    public static void main(String[] args) {

        MySharedClass sharedClass = new MySharedClass();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedClass.waitUntilComplete();
            }
        });

        Thread threadB_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedClass.complate();
            }
        });

        Thread threadB_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedClass.complate();
            }
        });

        threadA.start();
        threadB_1.start();
        threadB_2.start();
    }
}
