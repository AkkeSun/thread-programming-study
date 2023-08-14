package com.example.threadprogrammingstudy.issue;

/*
   데드락 (교착상태) : 트레인
   동시성 보장을 위해 락킹된 로직을 많은 쓰레드가 접근할 때
   먼저 들어온 쓰레드가 실행이 완료될 때 까지 기다리다가 멈춰버리는 현상

    아래 네 가지 조건이 모두 충족될 때 데드락이 발생한다
   - 상호배제 : 한 번에 한 개의 쓰레드만 접근할 수 있는 로직
   - 점유와 대기 : 최초 하나의 쓰레드가 리소스를 점유하여 다른 리소스에 대기
   - 비선점 : 스레드가 사용 완료할 때까지 리소스를 사용할 수 없음
   - 순환 대기 : 철도 A를 점유한 쓰레드는 철도 B를 기다리고 철도 B를 점유한 쓰레드는 철도 A를 기다리는 상황
 */
public class MainClass {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread trainAThread = new Thread(new TrainA(intersection));
        Thread trainBThread = new Thread(new TrainB(intersection));

        trainAThread.start();
        trainBThread.start();
    }
}
