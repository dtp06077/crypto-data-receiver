package com.example.cryptodatareceiver.rest.executor;

import com.example.cryptodatareceiver.dto.request.object.SaveTickerRequestDto;
import com.example.cryptodatareceiver.kafka.KafkaProducerService;
import com.example.cryptodatareceiver.rest.service.TickerService;
import com.example.cryptodatareceiver.transfer.JsonToRequestTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TickerExecutor {

    private final TickerService tickerService;
    private final KafkaProducerService kafkaProducerService;
    private final JsonToRequestTransfer jsonToRequestTransfer;

    @Scheduled(fixedRate = 30000)
    public void tickerProcess() {
        String textMessage = tickerService.getTickerRequest("KRW-BTC");
        System.out.println(textMessage);
//        SaveTickerRequestDto requestDto = jsonToRequestTransfer.transfer(textMessage);
//        System.out.println(requestDto.getAccTradePrice());
    }
}
