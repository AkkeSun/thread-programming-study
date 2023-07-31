package com.example.threadprogrammingstudy.callable;

import java.util.concurrent.Callable;
import lombok.extern.slf4j.Slf4j;

/*
    Callable <?> : 리턴값이 있는 Thread
 */
@Slf4j
public class MyCallable implements Callable<Integer> {

    private int[] data;
    private int startIndex;
    private int endIndex;

    public MyCallable(int[] data, int startIndex, int endIndex){
        this.data = data;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public Integer call() throws Exception {
        log.info("Callable Start");
        int result = 0;
        for (int i = startIndex; i < endIndex; i++) {
            result += data[i];
        }
        log.info("Callable End : " + result);
        return result;
    }
}
