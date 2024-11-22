package com.example.cryptobidai.dto.request;

import org.json.JSONArray;
import org.json.JSONObject;

public class OrderBookRequest extends Request {

    double level;

    public OrderBookRequest(String ticket, String type, String[] codes, String format, double level) {
        super(ticket, type, codes, format);
        this.level = level;
    }

    @Override
    public JSONObject typeFieldToJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", this.type);
        jsonObject.put("codes", new JSONArray(this.codes));
        jsonObject.put("level", this.level);

        return jsonObject;
    }
}
