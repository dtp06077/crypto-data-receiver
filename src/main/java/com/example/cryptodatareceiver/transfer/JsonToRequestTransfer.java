package com.example.cryptodatareceiver.transfer;

import com.example.cryptodatareceiver.dto.request.object.SaveTickerRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonToRequestTransfer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public SaveTickerRequestDto transfer(String textMessage) {
        try {
            return objectMapper.readValue(textMessage, SaveTickerRequestDto.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
