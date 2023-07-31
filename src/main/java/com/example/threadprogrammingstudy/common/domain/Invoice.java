package com.example.threadprogrammingstudy.common.domain;

import lombok.Getter;

@Getter
public class Invoice {
    private int invoice;
    private String comCode;
    private String userName;
    private String status;

    public Invoice(InvoiceLegacy invoiceLegacy){
        this.invoice = invoiceLegacy.getInvoice();
        this.comCode = invoiceLegacy.getComCode();
        this.userName = invoiceLegacy.getUserName();
        this.status = invoiceLegacy.getStatus();
    }
}
