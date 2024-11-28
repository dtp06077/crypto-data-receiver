package com.example.cryptodatareceiver.rest.executor;

import com.example.cryptodatareceiver.kafka.KafkaProducerService;
import com.example.cryptodatareceiver.rest.service.TickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TickerExecutor {

    private final TickerService tickerService;
    private final KafkaProducerService kafkaProducerService;

    //1분마다 Bithumb REST API 요청 후 카프카 서버 송신 로직
    @Scheduled(fixedRate = 60000)
    public void tickerProcess() {
        String textMessage = tickerService.getTickerRequest("KRW-BTC");
        kafkaProducerService.sendToProducer("crypto_topic_dev", textMessage);
    }
}
