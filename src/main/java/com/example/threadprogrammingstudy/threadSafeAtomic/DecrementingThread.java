package com.example.threadprogrammingstudy.threadSafeAtomic;

import com.example.threadprogrammingstudy.threadSafe.InventoryCounter2;
import java.util.concurrent.atomic.AtomicInteger;

public class DecrementingThread extends Thread {

    private final AtomicInteger atomicInteger;

    public DecrementingThread(AtomicInteger atomicInteger){
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        for (int i=0; i< 100000; i++){
            atomicInteger.addAndGet(-i);
        }
    }
}
