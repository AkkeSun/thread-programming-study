package com.example.threadprogrammingstudy.common.controller;

import com.example.threadprogrammingstudy.async.AsyncRunService;
import com.example.threadprogrammingstudy.async.AsyncService;
import com.example.threadprogrammingstudy.fixedThreadPool.FixedTreadPoolSyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final FixedTreadPoolSyncService fixedTreadPoolSyncService;
    private final AsyncRunService asyncRunService;

    @GetMapping("/test1")
    public void fixedTreadPoolSyncServiceTest(){
        fixedTreadPoolSyncService.sync();
    }

    @GetMapping("/test2")
    public void asyncServiceTest(){
        asyncRunService.sync();
    }
}
