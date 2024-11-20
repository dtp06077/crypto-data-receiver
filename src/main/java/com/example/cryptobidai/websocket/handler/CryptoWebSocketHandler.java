package com.example.cryptobidai.websocket.handler;

import com.example.cryptobidai.constant.BhConstant;
import com.example.cryptobidai.transfer.JsonRequestTransfer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CryptoWebSocketHandler extends BinaryWebSocketHandler {

    private final WebSocketClient webSocketClient;

    @PostConstruct
    public void connectToWebSocket() {

        String url = BhConstant.WS_PUBLIC_URL;

        BinaryWebSocketHandler binaryWebSocketHandler = new BinaryWebSocketHandler() {

            @Override
            public void afterConnectionEstablished(WebSocketSession session) {
                List<String> codesList = new ArrayList<>();
                codesList.add("KRW-BTC");
                codesList.add("KRW-ETH.3");
                String message = JsonRequestTransfer.orderBookRequestTransfer("test example", codesList, 10);
                System.out.println(message);
                try {
                    session.sendMessage(new TextMessage(message));
                } catch (Exception e) {
                    System.out.println("error: " + e.getMessage());
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
        };

        WebSocketConnectionManager connectionManager = new WebSocketConnectionManager(webSocketClient, binaryWebSocketHandler, url);
        connectionManager.start();
    }
}
