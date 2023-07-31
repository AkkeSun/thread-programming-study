package com.example.threadprogrammingstudy.async;

import com.example.threadprogrammingstudy.common.domain.Invoice;
import com.example.threadprogrammingstudy.common.domain.InvoiceLegacy;
import com.example.threadprogrammingstudy.common.repository.InvoiceLegacyRepository;
import com.example.threadprogrammingstudy.common.repository.InvoiceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsyncService {

    private final InvoiceLegacyRepository invoiceLegacyRepository;
    private final InvoiceRepository invoiceRepository;

    @Async
    public void sync(String comCode){
        List<InvoiceLegacy> invoiceLegacyList = invoiceLegacyRepository.findAllByComCode(comCode);
        log.info(Thread.currentThread().getName() + " : AsyncService Start");
        for (InvoiceLegacy invoiceLegacy : invoiceLegacyList) {
            invoiceRepository.update(new Invoice(invoiceLegacy));
        }
        log.info(Thread.currentThread().getName() + "AsyncService End");
    }
}
