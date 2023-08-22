package com.example.threadprogrammingstudy.threadSafeAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        IncrementingThread incrementingThread = new IncrementingThread(atomicInteger);
        DecrementingThread decrementingThread = new DecrementingThread(atomicInteger);

        incrementingThread.start();;
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();

        System.out.println("Result : " + atomicInteger.get());
    }

}
