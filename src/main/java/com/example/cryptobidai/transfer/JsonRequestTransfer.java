package com.example.cryptobidai.transfer;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JsonRequestTransfer {

    public static JSONArray jsonArray;

    public static String orderBookRequestTransfer(String ticketName, List<String> codesList, int level) {
        // 첫 번째 객체 생성
        JSONObject ticketObject = new JSONObject();
        ticketObject.put("ticket", ticketName);

        // 두 번째 객체 생성
        JSONObject typeObject = new JSONObject();
        typeObject.put("type", "orderbook");

        typeObject.put("codes", new JSONArray(codesList));
        
        typeObject.put("level", level); // 기본값

        // 세 번째 객체 생성
        JSONObject formatObject = new JSONObject();
        formatObject.put("format", "DEFAULT");

        jsonArray = new JSONArray();
        jsonArray.put(ticketObject);
        jsonArray.put(typeObject);
        jsonArray.put(formatObject);

        return jsonArray.toString();
    }
}
