package com.example.cryptodatareceiver.dto.request.json;


public class JsonTradeRequestDto extends JsonRequestDto {

    public JsonTradeRequestDto(String ticket, String type, String[] codes, String format) {
        super(ticket, type, codes, format); // 부모 클래스의 생성자 호출
    }
}

