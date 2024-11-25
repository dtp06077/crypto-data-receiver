package com.example.cryptodatareceiver.dto.response;

import com.example.cryptodatareceiver.constant.ResponseCode;
import com.example.cryptodatareceiver.constant.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SaveTickerResponseDto extends ResponseDto {

    private SaveTickerResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    //Http Status 200
    public static ResponseEntity<SaveTickerResponseDto> success() {
        SaveTickerResponseDto result = new SaveTickerResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
