package com.payment.razorpay.web;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwillioResource {
    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS() {

        Twilio.init("AC6d340b43c5e972e1eba9876aaa041f02", "5d66b4aaa7698c1b4c5983aee63431fb");

        Message.creator(new PhoneNumber("+919049522162"),
                new PhoneNumber("+12707517226"), "Hello from Twilio 📞").create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}
