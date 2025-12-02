package com.example.windows.qulifiervsprimary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CheckOutServiceCallPrimary {

    private  final PaymentSerivce  paymentSerivce;

    @Autowired
    public CheckOutServiceCallPrimary(@Qualifier ("Gpay") PaymentSerivce paymentSerivce) {
        this.paymentSerivce = paymentSerivce;
    }

   public String doingPayment() {
       return  paymentSerivce.doPayment(1200.99);
   }
}
