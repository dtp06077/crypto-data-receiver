package com.example.cryptobidai.transfer;

import com.example.cryptobidai.dto.request.OrderBookRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class TextToJsonTransfer {

    private JSONArray jsonArray;

    public String orderBookRequestTransfer(OrderBookRequest request) {

        // ticket field 생성
        JSONObject ticketObject = new JSONObject();
        ticketObject.put("ticket", request.getTicket());

        // type field 생성
        JSONObject typeObject = new JSONObject();
        typeObject.put("type", request.getType());

        typeObject.put("codes", new JSONArray(request.getCodes()));
        
        typeObject.put("level", request.getLevel()); // 기본값

        // format field 생성
        JSONObject formatObject = new JSONObject();
        formatObject.put("format", request.getFormat());

        jsonArray = new JSONArray();
        jsonArray.put(ticketObject);
        jsonArray.put(typeObject);
        jsonArray.put(formatObject);

        return jsonArray.toString();
    }
}
