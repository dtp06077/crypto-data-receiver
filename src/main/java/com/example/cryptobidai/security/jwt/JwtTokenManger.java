package com.example.cryptobidai.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.cryptobidai.security.constant.BhConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtTokenManger {

    private final BhConstant bhConstant;

    private Algorithm algorithm;
    private String jwtToken;

    private String createToken() {

        algorithm = Algorithm.HMAC256(bhConstant.getSECRETKEY());

        jwtToken = JWT.create()
                .withClaim("access_key", bhConstant.getAPIKEY())
                .withClaim("nonce", UUID.randomUUID().toString())
                .withClaim("timestamp", System.currentTimeMillis())
                .sign(algorithm);

        return "Bearer " + jwtToken;
    }
}
