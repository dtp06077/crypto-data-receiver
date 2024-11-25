package com.example.cryptodatareceiver.dto.request.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonOrderBookRequestDto extends JsonRequestDto {

    double level;

    public JsonOrderBookRequestDto(String ticket, String type, String[] codes, String format, double level) {
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
