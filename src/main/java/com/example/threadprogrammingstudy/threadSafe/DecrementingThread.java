package com.example.threadprogrammingstudy.threadSafe;

public class DecrementingThread extends Thread {

    private final InventoryCounter2 inventoryCounter;

    public DecrementingThread(InventoryCounter2 inventoryCounter){
        this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run() {
        for (int i=0; i< 100000; i++){
            inventoryCounter.decrement();
        }
    }
}
