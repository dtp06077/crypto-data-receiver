package com.example.cryptodatareceiver.dto.request.json;

public class JsonTickerRequestDto extends JsonRequestDto {

    public JsonTickerRequestDto(String ticket, String type, String[] codes, String format) {
        super(ticket, type, codes, format); // 부모 클래스의 생성자 호출
    }
}
