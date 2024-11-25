package com.example.cryptodatareceiver.rest.service;

import com.example.cryptodatareceiver.dto.response.SaveTickerResponseDto;
import org.springframework.http.ResponseEntity;

public interface TickerService {

    ResponseEntity<? super SaveTickerResponseDto> saveTickerRequest(String textMessage);
}
