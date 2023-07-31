package com.example.threadprogrammingstudy.fixedThreadPool;

import com.example.threadprogrammingstudy.common.domain.Invoice;
import com.example.threadprogrammingstudy.common.domain.InvoiceLegacy;
import com.example.threadprogrammingstudy.common.repository.InvoiceLegacyRepository;
import com.example.threadprogrammingstudy.common.repository.InvoiceRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/*
    비동기처리할 비지니스 로직 작성
 */
@Slf4j
public class InvoiceSyncWorker implements Runnable{

    private final String comCode;
    private final InvoiceLegacyRepository invoiceLegacyRepository;
    private final InvoiceRepository invoiceRepository;

    public InvoiceSyncWorker(String comCode, InvoiceLegacyRepository invoiceLegacyRepository,
        InvoiceRepository invoiceRepository){
        this.comCode = comCode;
        this.invoiceLegacyRepository = invoiceLegacyRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void run() {
        List<InvoiceLegacy> invoiceLegacyList = invoiceLegacyRepository.findAllByComCode(comCode);
        log.info(Thread.currentThread().getName() + " : InvoiceSyncWorker Start");
        for (InvoiceLegacy invoiceLegacy : invoiceLegacyList) {
            invoiceRepository.update(new Invoice(invoiceLegacy));
            // 하나의 Thread 가 독점실행이 되지 않도록 처리
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info(Thread.currentThread().getName() + " InvoiceSyncWorker End");

    }
}