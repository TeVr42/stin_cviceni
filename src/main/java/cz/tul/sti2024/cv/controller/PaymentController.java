package cz.tul.sti2024.cv.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.tul.sti2024.cv.exceptions.UnknownPaymentTypeException;
import cz.tul.sti2024.cv.model.Payment;
import cz.tul.sti2024.cv.services.PaymentHandler;
import cz.tul.sti2024.cv.services.PaymentTransformations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class PaymentController {

    private final PaymentHandler paymentHandler;
    PaymentTransformations paymentTransformations;


    public PaymentController(PaymentHandler paymentHandler, PaymentTransformations paymentTransformations) {
        this.paymentHandler = paymentHandler;
        this.paymentTransformations = paymentTransformations;
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
        Payment payment = paymentTransformations.transformJsonIntoPayment(payload);
        paymentHandler.handlePayment(payment);
        return "payment processed successfully";
        } catch (UnknownPaymentTypeException e) {
            return "unknown payment type";
        } catch (JsonProcessingException e) {
            return "payment rejected";
        }
    }
}
