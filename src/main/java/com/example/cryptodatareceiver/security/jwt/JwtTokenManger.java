package com.example.cryptodatareceiver.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.cryptodatareceiver.security.constant.BhAppKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtTokenManger {

    private final BhAppKey bhAppKey;

    private Algorithm algorithm;
    private String jwtToken;

    private String createToken() {

        algorithm = Algorithm.HMAC256(bhAppKey.getSECRETKEY());

        jwtToken = JWT.create()
                .withClaim("access_key", bhAppKey.getAPIKEY())
                .withClaim("nonce", UUID.randomUUID().toString())
                .withClaim("timestamp", System.currentTimeMillis())
                .sign(algorithm);

        return "Bearer " + jwtToken;
    }
}
