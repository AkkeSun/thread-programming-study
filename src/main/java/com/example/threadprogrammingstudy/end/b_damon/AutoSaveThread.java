package com.example.threadprogrammingstudy.end.b_damon;

public class AutoSaveThread extends Thread{
    @Override
    public void run() {

        while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }
            if(MainClass.autoSave){
                System.out.println("임시 저장 되었습니다");
            }
        }
    }
}
