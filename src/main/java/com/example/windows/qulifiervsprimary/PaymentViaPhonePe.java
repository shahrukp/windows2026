package com.example.windows.qulifiervsprimary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Qualifier("phonpPe")
public class PaymentViaPhonePe implements  PaymentSerivce{
    /**
     * @return
     */
    @Override
    public String  doPayment(Double amount) {
      String message= String.format("payment has been done via phonepe ! paid '%s' " ,amount);
        return message;
    }

}
