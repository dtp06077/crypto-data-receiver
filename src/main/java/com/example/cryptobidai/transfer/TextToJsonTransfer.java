package com.example.cryptobidai.transfer;

import com.example.cryptobidai.dto.request.OrderBookRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class TextToJsonTransfer {

    //코인 호가 요청 json 변환 메서드
    public String orderBookRequestTransfer(OrderBookRequest request) {

        // ticket field 생성
        JSONObject ticketObject = new JSONObject();
        ticketObject.put("ticket", request.getTicket());

        // type field 생성
        JSONObject typeObject = new JSONObject();
        typeObject.put("type", request.getType());

        typeObject.put("codes", new JSONArray(request.getCodes()));
        
        typeObject.put("level", request.getLevel());

        // format field 생성
        JSONObject formatObject = new JSONObject();
        formatObject.put("format", request.getFormat());

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(ticketObject);
        jsonArray.put(typeObject);
        jsonArray.put(formatObject);

        return jsonArray.toString();
    }
}
