package com.example.cryptodatareceiver.rest.executor;

import com.example.cryptodatareceiver.kafka.KafkaProducerService;
import com.example.cryptodatareceiver.rest.service.TickerService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
@RequiredArgsConstructor
public class TickerExecutor {

    private final TickerService tickerService;
    private final KafkaProducerService kafkaProducerService;

    //1분마다 Bithumb REST API 요청 후 카프카 서버 송신 로직
    @Scheduled(fixedRate = 60000)
    public void tickerProcess() {
        String textMessage = tickerService.getTickerRequest("KRW-BTC");

        //bufferTime을 producer에서 관리하도록 수정
        String bufferTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        textMessage = addBufferTimeToJson(textMessage, bufferTime);

        kafkaProducerService.sendToProducer("crypto_topic_dev", textMessage);
    }

    private String addBufferTimeToJson(String json, String bufferTime) {
        JSONObject jsonObject = new JSONObject(json);
        jsonObject.put("buffer_time", bufferTime);

        return jsonObject.toString();
    }
}
