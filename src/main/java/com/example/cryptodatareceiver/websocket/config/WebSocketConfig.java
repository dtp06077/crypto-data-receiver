package com.example.cryptodatareceiver.websocket.config;

import com.example.cryptodatareceiver.constant.Constant;
import com.example.cryptodatareceiver.websocket.handler.CryptoWebSocketHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final CryptoWebSocketHandler cryptoWebSocketHandler;

    public WebSocketConfig(CryptoWebSocketHandler cryptoWebSocketHandler) {
        this.cryptoWebSocketHandler = cryptoWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(cryptoWebSocketHandler, "/receiver")
                .setAllowedOrigins("http://localhost:5000"); //임시로 모든 출처에서의 연결 허용
    }

    @Bean
    public WebSocketClient webSocketClient() {
        return new StandardWebSocketClient();
    }


    // WebSocket 연결을 위한 메서드
    @Bean
    public WebSocketConnectionManager connectionManager() {
        WebSocketConnectionManager connectionManager = new WebSocketConnectionManager(
                webSocketClient(),
                cryptoWebSocketHandler,
                Constant.WS_PUBLIC_URL // 빗썸 url
        );
        connectionManager.start(); // 연결 시작
        return connectionManager;
    }
}
