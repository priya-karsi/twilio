package com.payment.razorpay.web;

import com.payment.razorpay.domain.TransactionDetails;
import com.payment.razorpay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;
    @GetMapping("/payment/{amount}")
    public TransactionDetails createTransaction(@PathVariable Double amount){

        return this.paymentService.createTransaction(amount);

    }
}
