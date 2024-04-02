package cz.tul.sti2024.cv.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.tul.sti2024.cv.model.Payment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class PaymentController {

    private final ObjectMapper objectMapper;
    private final PaymentHandler paymentHandler;

    public PaymentController() {

        this.objectMapper = new ObjectMapper();
        this.paymentHandler = new PaymentHandler();
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/time")
    public String getTime() {
        return new Date(System.currentTimeMillis()).toString();
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String paymentProcesing(String payload) {
        try {
        Payment payment = objectMapper.readValue(payload, Payment.class);
        if (paymentHandler.handlePayment(payment) == 1) {
            return "payment processed succesfully";
        }
        return "unknown payment type";
        } catch (JsonProcessingException e) {
            return "payment rejected";
        }
    }
}
