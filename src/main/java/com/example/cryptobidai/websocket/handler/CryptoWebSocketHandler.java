package com.example.cryptobidai.websocket.handler;


import com.example.cryptobidai.dto.request.OrderBookRequest;
import com.example.cryptobidai.dto.request.Request;
import com.example.cryptobidai.dto.request.TradeRequest;
import com.example.cryptobidai.kafka.KafkaProducerService;
import com.example.cryptobidai.transfer.BinaryToTextTransfer;
import com.example.cryptobidai.transfer.TextToJsonTransfer;
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

    private final TextToJsonTransfer textTojsonTransfer;
    private final BinaryToTextTransfer binaryToTextTransfer;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {

        String[] codes = new String[]{"KRW-BTC"};

        Request tradeRequest = new TradeRequest("test example", "trade", codes, "DEFAULT");
        Request orderBookRequest = new OrderBookRequest("test example", "orderbook", codes, "DEFAULT", 1);
        String message = textTojsonTransfer.requestTransfer(orderBookRequest, tradeRequest);

        try {
            session.sendMessage(new TextMessage(message)); // 요청 메시지를 전송
        } catch (Exception e) {
            System.err.println("error message: " + e.getMessage());
        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        //BinaryMessage를 텍스트로 변환
        String textMessage = binaryToTextTransfer.orderBookResponseTransfer(message);
//        kafkaProducerService.sendToProducer("test", textMessage);
        System.out.println("Received message: " + textMessage);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("WebSocket connection closed: " + status);
    }
}
