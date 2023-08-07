package com.example.threadprogrammingstudy.nonThreadSafe;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();

        // inventoryCounter : 데이터 공유 발생
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
