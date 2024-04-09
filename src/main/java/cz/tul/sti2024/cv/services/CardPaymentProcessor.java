package cz.tul.sti2024.cv.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.tul.sti2024.cv.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class CardPaymentProcessor implements IPaymentProcessor {

    private final PaymentTransformations transformator;
    public CardPaymentProcessor(PaymentTransformations transformator) {
        this.transformator = transformator;
    }
    @Override
    public void processPayment(Payment payment){
        cash(payment);
    }

    private void cash(Payment payload) {
        try {
            System.out.println(transformator.transformXMLFromPayment(payload));
        } catch (JsonProcessingException e) {
            System.out.println("ERROR durring JSON processing occured");
        }
    }
}
