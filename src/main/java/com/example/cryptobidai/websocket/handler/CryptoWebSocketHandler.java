package com.example.cryptobidai.websocket.handler;

import com.example.cryptobidai.constant.BhConstant;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
public class CryptoWebSocketHandler extends TextWebSocketHandler {

    private final WebSocketClient webSocketClient;

    @PostConstruct
    public void connectToWebSocket() {

        String url = BhConstant.WS_PUBLIC_URL;

        TextWebSocketHandler textWebSocketHandler = new TextWebSocketHandler() {

            @Override
            public void afterConnectionEstablished(WebSocketSession session) {
                String message =
                session.sendMessage(new TextMessage());
            }
        };
    }
}
