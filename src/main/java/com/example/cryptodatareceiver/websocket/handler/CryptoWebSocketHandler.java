package com.example.cryptodatareceiver.websocket.handler;

import com.example.cryptodatareceiver.dto.request.json.JsonRequestDto;
import com.example.cryptodatareceiver.dto.request.json.JsonTradeRequestDto;
import com.example.cryptodatareceiver.kafka.KafkaProducerService;
import com.example.cryptodatareceiver.transfer.BinaryToJsonTransfer;
import com.example.cryptodatareceiver.transfer.RequestToJsonTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;


@Component
@RequiredArgsConstructor
public class CryptoWebSocketHandler extends BinaryWebSocketHandler {

    private final RequestToJsonTransfer textTojsonTransfer;
    private final BinaryToJsonTransfer binaryToTextTransfer;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {

        String[] codes = new String[]{"KRW-BTC"};

        JsonRequestDto tradeRequest = new JsonTradeRequestDto("test example", "ticker", codes, "DEFAULT");

        String message = textTojsonTransfer.transfer(tradeRequest);

        try {
            session.sendMessage(new TextMessage(message)); // 요청 메시지를 전송
        } catch (Exception e) {
            System.err.println("error message: " + e.getMessage());
        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        //BinaryMessage를 텍스트로 변환
        String textMessage = binaryToTextTransfer.transfer(message);
//        kafkaProducerService.sendToProducer("test", textMessage);
        System.out.println("Received message: " + textMessage);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("WebSocket connection closed: " + status);
    }
}
