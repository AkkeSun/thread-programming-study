package com.example.threadprogrammingstudy.nonThreadSafe;

public class IncrementingThread extends Thread {

    private final InventoryCounter inventoryCounter;

    public IncrementingThread(InventoryCounter inventoryCounter){
        this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run() {
        for (int i=0; i< 100000; i++){
            inventoryCounter.increment();
        }
    }
}
