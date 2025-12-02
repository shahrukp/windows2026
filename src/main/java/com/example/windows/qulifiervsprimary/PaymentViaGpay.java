package com.example.windows.qulifiervsprimary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Qualifier("Gpay")//parameters allowed here
// when using beloe must be undersatnd
// @Service
//@Primary  // ✅ No parameters allowed here
public class PaymentViaGpay implements  PaymentSerivce{
    @Override

    public String doPayment(Double amount) {
        return "payment done via gpay !";
    }
}
