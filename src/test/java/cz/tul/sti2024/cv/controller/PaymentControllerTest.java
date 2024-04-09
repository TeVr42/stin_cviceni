package cz.tul.sti2024.cv.controller;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private PaymentController paymentController;

    @Test
    void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello world")));
    }

    @Test
    void testGetTime() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/time").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void testCardPayment() throws IOException {
        String payload = Files.readString(new ClassPathResource("inputdata/input_valid_card.json").getFile().toPath());
        Assertions.assertEquals("payment processed successfully", paymentController.paymentProcesing(payload));
    }

    @Test
    void testCashPayment() throws IOException {
        String payload = Files.readString(new ClassPathResource("inputdata/input_valid_cash.json").getFile().toPath());
        Assertions.assertEquals("payment processed successfully", paymentController.paymentProcesing(payload));
    }

    @Test
    void testMissingTypePayment() throws IOException {
        String payload = Files.readString(new ClassPathResource("inputdata/input_invalid_missing_type.json").getFile().toPath());
        Assertions.assertEquals("unknown payment type", paymentController.paymentProcesing(payload));
    }


}
