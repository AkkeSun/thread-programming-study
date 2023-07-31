package com.example.threadprogrammingstudy.async;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class AsyncRunService {
    private final AsyncService asyncService;

    public void sync(){
        List<String> comCodeList = Arrays.asList("11", "22", "33", "44", "55", "66", "77", "88", "99", "00");
        for (String comCode : comCodeList) {
            asyncService.sync(comCode);
        }
    }
}
