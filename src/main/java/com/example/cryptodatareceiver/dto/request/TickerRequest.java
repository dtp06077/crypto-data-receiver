package com.example.cryptodatareceiver.dto.request;

public class TickerRequest extends Request {

    public TickerRequest(String ticket, String type, String[] codes, String format) {
        super(ticket, type, codes, format); // 부모 클래스의 생성자 호출
    }
}
