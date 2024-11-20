package com.example.cryptobidai.dto.request;

import lombok.Data;

import java.util.ArrayList;

@Data
public class OrderBookRequest extends BhRequest {

    double level;
    boolean isOnlySnapshot;
    boolean isOnlyRealtime;

    public OrderBookRequest() {
        //ticket field
        this.ticket = "test example";

        //type field
        this.type = "orderbook";

        this.codes = new ArrayList<>();
        codes.add("KRW-BTC");

        this.level = 1;
        this.isOnlySnapshot = false;
        this.isOnlyRealtime = false;

        //format field
        this.format = "DEFAULT";
    }
}
