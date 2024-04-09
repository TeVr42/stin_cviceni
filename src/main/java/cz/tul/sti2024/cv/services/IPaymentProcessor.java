package cz.tul.sti2024.cv.services;

import cz.tul.sti2024.cv.model.Payment;

public interface IPaymentProcessor {

    void processPayment(Payment payment);
}
