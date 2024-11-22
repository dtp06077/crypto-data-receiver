package com.example.cryptobidai.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

@Data
@AllArgsConstructor
public class OrderBookRequest extends Request {

    double level;

    @Override
    public JSONObject typeFieldToJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", this.type);
        jsonObject.put("codes", new JSONArray(this.codes));
        jsonObject.put("level", this.level);

        return jsonObject;
    }
}
