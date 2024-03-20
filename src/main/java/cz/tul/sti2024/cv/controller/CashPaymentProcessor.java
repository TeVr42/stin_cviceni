package cz.tul.sti2024.cv.controller;

import cz.tul.sti2024.cv.model.Payment;

public class CashPaymentProcessor implements IpaymentProcessor {
    @Override
    public void processPayment(Payment payment) {
        pay(payment);
    }

    private void pay(Payment payment){
        String toPay = payment.getAmount() + "/" + payment.getCurrency();
        System.out.println(toPay);
    }
}
