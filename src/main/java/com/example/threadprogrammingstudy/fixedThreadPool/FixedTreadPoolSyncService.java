package com.example.threadprogrammingstudy.fixedThreadPool;

import com.example.threadprogrammingstudy.common.repository.InvoiceLegacyRepository;
import com.example.threadprogrammingstudy.common.repository.InvoiceRepository;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
    스케쥴러가 호출하는 서비스 (스케쥴러에 바로 작성해도 됩니다)
 */
@Service
@RequiredArgsConstructor
public class FixedTreadPoolSyncService {

    private final InvoiceLegacyRepository invoiceLegacyRepository;
    private final InvoiceRepository invoiceRepository;

    public void sync() {
        ExecutorService executor =  Executors.newFixedThreadPool(10);
        List<String> comCodeList = Arrays.asList("11", "22", "33", "44", "55", "66", "77", "88", "99", "00");
        for (String comCode : comCodeList) {
            // 비지니스로직 실행
            executor.execute(new InvoiceSyncWorker(comCode, invoiceLegacyRepository, invoiceRepository));
        }
        // 실행중인 모든 Task 가 수행되면 종료
        executor.shutdown();
    }
}
