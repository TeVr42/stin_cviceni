package cz.tul.sti2024.cv.services;


import cz.tul.sti2024.cv.exceptions.UnknownPaymentTypeException;
import cz.tul.sti2024.cv.model.Payment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentHandler {
    private final Map<String, IPaymentProcessor> paymentProcessorMap;

    public PaymentHandler(CardPaymentProcessor cardPaymentProcessor, CashPaymentProcessor cashPaymentProcessor) {
        paymentProcessorMap = new HashMap<>();
        paymentProcessorMap.put("CARD", cardPaymentProcessor);
        paymentProcessorMap.put("CASH", cashPaymentProcessor);
    }

    public void handlePayment(Payment payment) throws UnknownPaymentTypeException {
        IPaymentProcessor paymentProcessor = paymentProcessorMap.get(payment.getPaymentType());
        if (paymentProcessor != null) {
            paymentProcessor.processPayment(payment);
        } else {
            throw new UnknownPaymentTypeException("Neznámý typ platby");
        }
    }
}
