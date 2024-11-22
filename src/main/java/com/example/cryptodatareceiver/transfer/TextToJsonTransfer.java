package com.example.cryptodatareceiver.transfer;

import com.example.cryptodatareceiver.dto.request.Request;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class TextToJsonTransfer {

    //요청 json 변환 메서드
    public String requestTransfer(Request... requests) {

        JSONArray jsonArray = new JSONArray();

        for (Request request : requests) {
            // 각 Request 객체의 필드를 JSON으로 변환하여 추가
            jsonArray.put(request.ticketFieldToJson());
            jsonArray.put(request.typeFieldToJson());
            jsonArray.put(request.formatFieldToJson());
        }

        return jsonArray.toString();
    }
}
