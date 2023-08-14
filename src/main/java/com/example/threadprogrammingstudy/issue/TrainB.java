package com.example.threadprogrammingstudy.issue;

import java.util.Random;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrainB implements Runnable{

    private final Intersection intersection;
    private Random random = new Random();

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            intersection.takeRoadB();
        }
    }
}
