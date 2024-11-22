package com.example.cryptobidai.transfer;

import com.example.cryptobidai.dto.request.OrderBookRequest;
import com.example.cryptobidai.dto.request.TradeRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class TextToJsonTransfer {

    //요청 json 변환 메서드
    public String orderTradeRequestTransfer(OrderBookRequest orderBookRequest, TradeRequest  tradeRequest) {

        JSONArray jsonArray = new JSONArray();

        //체결가 요청 필드
        jsonArray.put(tradeRequest.ticketFieldToJson());
        jsonArray.put(tradeRequest.typeFieldToJson());
        jsonArray.put(tradeRequest.formatFieldToJson());

        //호가 요청 필드
        jsonArray.put(orderBookRequest.ticketFieldToJson());
        jsonArray.put(orderBookRequest.typeFieldToJson());
        jsonArray.put(orderBookRequest.formatFieldToJson());

        return jsonArray.toString();
    }
}
