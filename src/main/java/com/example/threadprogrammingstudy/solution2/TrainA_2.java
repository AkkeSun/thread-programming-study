package com.example.threadprogrammingstudy.solution2;

import java.util.Random;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrainA_2 implements Runnable{

    private final Intersection_2 intersection;
    private Random random = new Random();

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            intersection.takeRoadA();
        }
    }
}
