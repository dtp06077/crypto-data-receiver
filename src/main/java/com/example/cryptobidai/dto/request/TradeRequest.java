package com.example.cryptobidai.dto.request;


public class TradeRequest extends Request {

    public TradeRequest(String ticket, String type, String[] codes, String format) {
        super(ticket, type, codes, format); // 부모 클래스의 생성자 호출
    }
}

