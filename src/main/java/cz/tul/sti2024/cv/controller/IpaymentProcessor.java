package cz.tul.sti2024.cv.controller;

import cz.tul.sti2024.cv.model.Payment;

public interface IpaymentProcessor {

    void processPayment(Payment payment);
}
