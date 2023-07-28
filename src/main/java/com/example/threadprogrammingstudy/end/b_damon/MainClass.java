package com.example.threadprogrammingstudy.end.b_damon;
/*
   autoSaveThread.setDaemon(true);
   main Thread 종료시 함께 종료시킨다
 */
public class MainClass {
    static boolean autoSave;
    public static void main(String[] args) throws InterruptedException {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        for(int i = 1 ; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println(i);
            if(i > 5) {
                autoSave = true;
            }
        }
        System.out.println("종료되었습니다");
    }
}
