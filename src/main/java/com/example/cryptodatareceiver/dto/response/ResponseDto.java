package com.example.cryptodatareceiver.dto.response;

import com.example.cryptodatareceiver.constant.ResponseCode;
import com.example.cryptodatareceiver.constant.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class ResponseDto {

    private String code;
    private String message;

    //HTTP Status 500
    public static ResponseEntity<ResponseDto> databaseError() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
