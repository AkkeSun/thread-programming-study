package com.example.threadprogrammingstudy.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    public int run(){

        log.info("Logic Start");
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int threadSize = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
        int chunkSize = data.length / threadSize;

        List<Future<Integer>> futures = new ArrayList<>();
        for(int i=0; i<threadSize; i++) {

            int startIndex = i * chunkSize;
            int endIndex = (i == threadSize - 1) ? data.length : (i + 1) * chunkSize;
            Callable<Integer> task = new MyCallable(data, startIndex, endIndex);

            // 비지니스 로직 실행
            futures.add(executorService.submit(task));
        }

        int result = 0;
        try {
            // 각 작업이 완료된 후 결과를 모아 최종 연산을 수행합니다.
            for (Future<Integer> future : futures) {
                result += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 스레드 풀 종료
        executorService.shutdown();

        log.info("Logic End " + result);
        return result;
    }
}
