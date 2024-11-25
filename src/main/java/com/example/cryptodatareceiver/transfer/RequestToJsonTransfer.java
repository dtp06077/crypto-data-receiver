package com.example.cryptodatareceiver.transfer;

import com.example.cryptodatareceiver.dto.request.json.JsonRequestDto;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class RequestToJsonTransfer {

    //요청 json 변환 메서드
    public String requestTransfer(JsonRequestDto... requests) {

        JSONArray jsonArray = new JSONArray();

        for (JsonRequestDto request : requests) {
            // 각 Request 객체의 필드를 JSON으로 변환하여 추가
            jsonArray.put(request.ticketFieldToJson());
            jsonArray.put(request.typeFieldToJson());
            jsonArray.put(request.formatFieldToJson());
        }

        return jsonArray.toString();
    }
}
