package com.example.threadprogrammingstudy.common.repository;

import com.example.threadprogrammingstudy.common.domain.Invoice;
import com.sun.net.httpserver.Authenticator.Success;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class InvoiceRepository {
    public void update(Invoice invoice){
        log.info(invoice.getComCode() + " " + invoice.getInvoice() + " : Invoice Update Success ");
    }
}
