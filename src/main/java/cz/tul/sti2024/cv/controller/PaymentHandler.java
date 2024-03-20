package cz.tul.sti2024.cv.controller;


import cz.tul.sti2024.cv.model.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentHandler {
    private final Map<String, IpaymentProcessor> paymentProcessorMap;

    public PaymentHandler() {
        paymentProcessorMap = new HashMap<>();
        paymentProcessorMap.put("CARD", new CardPaymentProcessor());
        paymentProcessorMap.put("CASH", new CashPaymentProcessor());
    }

    public int handlePayment(Payment payment) {
        IpaymentProcessor paymentProcessor = paymentProcessorMap.get(payment.getPaymentType());
        if (paymentProcessor != null) {
            paymentProcessor.processPayment(payment);
            return 1;
        } else {
            return 0;
        }
    }
}
