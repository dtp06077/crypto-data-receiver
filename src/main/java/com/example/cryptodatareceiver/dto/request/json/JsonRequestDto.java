package com.example.cryptodatareceiver.dto.request.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

@Data
@AllArgsConstructor
public class JsonRequestDto {
    String ticket;
    String type;
    String[] codes;
    String format;

    public JSONObject ticketFieldToJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ticket", this.ticket);
        return jsonObject;
    }

    public JSONObject typeFieldToJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", this.type);
        jsonObject.put("codes", new JSONArray(this.codes));
        return jsonObject;
    }

    public JSONObject formatFieldToJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("format", this.format);
        return jsonObject;
    }
}
