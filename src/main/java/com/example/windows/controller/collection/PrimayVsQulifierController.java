package com.example.windows.controller.collection;

import com.example.windows.qulifiervsprimary.CheckOutServiceCallPrimary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primary/qulifier/api/")
public class PrimayVsQulifierController {

    @Autowired
    private CheckOutServiceCallPrimary checkOutServiceCallPrimary;
// use of primary
    @GetMapping("payments")
    public String  doAnyPayments() {
    return  checkOutServiceCallPrimary.doingPayment();
    }
    // use of qulifier
    @GetMapping("payments/qulifier")
    public String  doAnyPaymentsS() {
        return  checkOutServiceCallPrimary.doingPayment();
    }
}
