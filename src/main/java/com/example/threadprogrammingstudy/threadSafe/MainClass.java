package com.example.threadprogrammingstudy.threadSafe;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter2 inventoryCounter = new InventoryCounter2();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        incrementingThread.start();;
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();

        // 0이 아닌 다른 값이 출력된다
        System.out.println("Result : " + inventoryCounter.getItems());
    }

}
