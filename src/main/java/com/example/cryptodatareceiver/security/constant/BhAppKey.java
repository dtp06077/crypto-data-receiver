package com.example.cryptodatareceiver.security.constant;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BhAppKey {

    @Value("${bh.apikey}")
    private String APIKEY;
    @Value("${bh.secretkey}")
    private String SECRETKEY;
}
