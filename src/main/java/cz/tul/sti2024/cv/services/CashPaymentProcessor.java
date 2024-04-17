package cz.tul.sti2024.cv.services;

import cz.tul.sti2024.cv.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class CashPaymentProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(Payment payment) {
        pay(payment);
    }

    private void pay(Payment payment){
        String toPay = payment.getAmount() + "/" + payment.getCurrency();
        System.out.println(toPay);
    }
}
