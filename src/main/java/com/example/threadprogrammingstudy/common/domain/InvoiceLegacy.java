package com.example.threadprogrammingstudy.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvoiceLegacy {
    private int invoice;
    private String comCode;
    private String userName;
    private String status;

}
