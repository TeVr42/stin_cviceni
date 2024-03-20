package cz.tul.sti2024.cv.controller;

import cz.tul.sti2024.cv.model.Payment;
import org.json.JSONObject;
import org.json.XML;

public class CardPaymentProcessor implements IpaymentProcessor {
    @Override
    public void processPayment(Payment payment) {
        cash(payment);
    }

    private void cash(Payment payload){
        JSONObject jsonObject = new JSONObject(payload);
        String xmlCash = XML.toString(jsonObject);
        System.out.println(xmlCash);
    }
}
