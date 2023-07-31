package com.example.threadprogrammingstudy.common.repository;

import com.example.threadprogrammingstudy.common.domain.InvoiceLegacy;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceLegacyRepository {

    public List<InvoiceLegacy> findAllByComCode(String comCode){
        List<InvoiceLegacy> invoiceLegacies = new ArrayList<>();
        for (int i =0; i<30; i++){
            invoiceLegacies.add(new InvoiceLegacy(i, comCode, comCode, comCode));
        }
        return invoiceLegacies;
    }
}
