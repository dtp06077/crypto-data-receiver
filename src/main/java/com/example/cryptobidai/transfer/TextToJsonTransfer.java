package com.example.cryptobidai.transfer;

import com.example.cryptobidai.dto.request.OrderBookRequest;
import com.example.cryptobidai.dto.request.TradeRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class TextToJsonTransfer {

    //요청 json 변환 메서드
    public String requestTransfer(OrderBookRequest request, TradeRequest  request2) {

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

        // ticket field 생성
        JSONObject ticketObject2 = new JSONObject();
        ticketObject2.put("ticket", request2.getTicket());

        // type field 생성
        JSONObject typeObject2 = new JSONObject();
        typeObject2.put("type", request2.getType());

        typeObject2.put("codes", new JSONArray(request2.getCodes()));

        // format field 생성
        JSONObject formatObject2 = new JSONObject();
        formatObject2.put("format", request2.getFormat());

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(ticketObject);
        jsonArray.put(typeObject);
        jsonArray.put(formatObject);
        jsonArray.put(ticketObject2);
        jsonArray.put(typeObject2);
        jsonArray.put(formatObject2);

        return jsonArray.toString();
    }
}
