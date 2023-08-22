package com.example.threadprogrammingstudy.threadSafeAtomic;

import com.example.threadprogrammingstudy.threadSafe.InventoryCounter2;
import java.util.concurrent.atomic.AtomicInteger;

public class IncrementingThread extends Thread {

    private final AtomicInteger atomicInteger;

    public IncrementingThread(AtomicInteger atomicInteger){
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        for (int i=0; i< 100000; i++){
            // https://backtony.github.io/java/2022-05-27-java-51/
            // atomicInteger.get(); // 데이터 추출
            // atomicInteger.set(i); // 데이터 세팅
            atomicInteger.addAndGet(i); // 해당 값을 더한다
        }
    }
}
