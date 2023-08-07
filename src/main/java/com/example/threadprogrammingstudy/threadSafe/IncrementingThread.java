package com.example.threadprogrammingstudy.threadSafe;

public class IncrementingThread extends Thread {

    private final InventoryCounter2 inventoryCounter;

    public IncrementingThread(InventoryCounter2 inventoryCounter){
        this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run() {
        for (int i=0; i< 100000; i++){
            inventoryCounter.increment();
        }
    }
}
