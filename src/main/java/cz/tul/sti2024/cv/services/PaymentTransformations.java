package cz.tul.sti2024.cv.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.tul.sti2024.cv.model.Payment;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

@Component
public class PaymentTransformations {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Payment transformJsonIntoPayment(String payload) throws JsonProcessingException {
        return objectMapper.readValue(payload, Payment.class);
    }

    public String transformXMLFromPayment(Payment payment) throws JsonProcessingException{
        JSONObject jsonObject = new JSONObject(payment);
        return XML.toString(jsonObject);
    }
}
