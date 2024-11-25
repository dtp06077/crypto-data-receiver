package com.example.cryptodatareceiver.dto.request.object;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaveTickerRequestDto {

    private double openingPrice;
    private double highPrice;
    private double lowPrice;
    private double tradePrice;
    private double prevClosingPrice;
    private double highest52WeekPrice;
    private double lowest52WeekPrice;
    private double tradeVolume;
    private double accTradeVolume;
    private double accTradePrice;
    private String tradeDate;
    private String tradeTime;
    private long tradeTimeStamp;
}
