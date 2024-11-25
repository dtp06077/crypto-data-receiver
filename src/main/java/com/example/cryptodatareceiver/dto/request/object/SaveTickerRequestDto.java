package com.example.cryptodatareceiver.dto.request.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaveTickerRequestDto {

    @JsonProperty("opening_price")
    private double openingPrice;

    @JsonProperty("high_price")
    private double highPrice;

    @JsonProperty("low_price")
    private double lowPrice;

    @JsonProperty("trade_price")
    private double tradePrice;

    @JsonProperty("prev_closing_price")
    private double prevClosingPrice;

    @JsonProperty("highest_52_week_price")
    private double highest52WeekPrice;

    @JsonProperty("lowest_52_week_price")
    private double lowest52WeekPrice;

    @JsonProperty("trade_volume")
    private double tradeVolume;

    @JsonProperty("acc_trade_volume")
    private double accTradeVolume;

    @JsonProperty("acc_trade_price")
    private double accTradePrice;

    @JsonProperty("trade_date")
    private String tradeDate;

    @JsonProperty("trade_time")
    private String tradeTime;

    @JsonProperty("trade_timestamp")
    private long tradeTimeStamp;
}
