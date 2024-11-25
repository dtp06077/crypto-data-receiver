package com.example.cryptodatareceiver.transfer;

import com.example.cryptodatareceiver.dto.request.object.SaveTickerRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JsonToRequestTransferTest {

    @Autowired
    private JsonToRequestTransfer jsonToRequestTransfer;

    @Test
    public void testTransfer() {
        // 예제 JSON 문자열
        String json = "{\"opening_price\":134095000,\"high_price\":136880000,\"low_price\":132200000,\"trade_price\":135468000,\"prev_closing_price\":134095000,\"highest_52_week_price\":138880000,\"lowest_52_week_price\":49425000,\"trade_volume\":0.00246816,\"acc_trade_volume\":867.29681046,\"acc_trade_price\":116795647197.11964,\"trade_date\":\"20241125\",\"trade_time\":\"151524\",\"trade_timestamp\":1732515324681}";

        // JSON 문자열을 DTO로 변환
        SaveTickerRequestDto dto = jsonToRequestTransfer.transfer(json);

        // 결과 검증
        assertNotNull(dto);
        assertEquals(134095000, dto.getOpeningPrice());
        assertEquals(136880000, dto.getHighPrice());
        assertEquals(132200000, dto.getLowPrice());
        assertEquals(135468000, dto.getTradePrice());
        assertEquals(134095000, dto.getPrevClosingPrice());
        assertEquals(138880000, dto.getHighest52WeekPrice());
        assertEquals(49425000, dto.getLowest52WeekPrice());
        assertEquals(0.00246816, dto.getTradeVolume());
        assertEquals(867.29681046, dto.getAccTradeVolume());
        assertEquals(116795647197.11964, dto.getAccTradePrice());
        assertEquals("20241125", dto.getTradeDate());
        assertEquals("151524", dto.getTradeTime());
        assertEquals(1732515324681L, dto.getTradeTimeStamp());
    }
}