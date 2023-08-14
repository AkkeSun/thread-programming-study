package com.example.threadprogrammingstudy.solution1;

import java.util.Random;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrainB_1 implements Runnable{

    private final Intersection_1 intersection;
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
