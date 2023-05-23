package com.payment.razorpay.service;

import com.payment.razorpay.domain.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private static final String key = "rzp_test_cr4PqjWThtSWt3";
    private static final String secret = "vgWLtx8S7ZfrVwPfeuHOp2jO";
    private static final String currency = "INR";

    public TransactionDetails createTransaction(Double amount){

        JSONObject jsObject = new JSONObject();
        jsObject.put("amount",amount*100);
        jsObject.put("currency",currency);
        jsObject.put("amount",amount);
        try {
            RazorpayClient razorpayClient = new RazorpayClient(key, secret);
            Order order = razorpayClient.orders.create(jsObject);
            System.out.println(order);
            return prepareTransactionDetails(order);
        } catch (RazorpayException e) {
            e.printStackTrace();
        }
        return null;
    }

    private TransactionDetails  prepareTransactionDetails(Order order){
        String orderid = order.get("id");
        String currency = order.get("currency");
        String key = order.get("key");
        Integer amount = order.get("amount");

        return  new TransactionDetails(orderid, currency, key, amount);
    }
}
