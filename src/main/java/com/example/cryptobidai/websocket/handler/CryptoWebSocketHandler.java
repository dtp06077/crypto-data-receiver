package com.example.cryptobidai.websocket.handler;


import com.example.cryptobidai.dto.request.OrderBookRequest;
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

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {

        OrderBookRequest request = new OrderBookRequest();
        String message = textTojsonTransfer.orderBookRequestTransfer(request);
        System.out.println(message);

        try {
            session.sendMessage(new TextMessage(message)); // 요청 메시지를 전송
        } catch (Exception e) {
            System.err.println("error message: " + e.getMessage());
        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        System.out.println("Received binary message: " + message.getPayload());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("WebSocket connection closed: " + status);
    }
}
