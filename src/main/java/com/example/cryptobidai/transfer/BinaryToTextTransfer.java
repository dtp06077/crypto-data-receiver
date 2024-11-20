package com.example.cryptobidai.transfer;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;

import java.nio.ByteBuffer;

@Component
public class BinaryToTextTransfer {

    //코인 호가 응답 text 변환 메서드
    public String orderBookResponseTransfer(BinaryMessage message) {
        ByteBuffer byteBuffer = message.getPayload();
        byte[] byteArray = new byte[byteBuffer.remaining()];
        byteBuffer.get(byteArray);
        return new String(byteArray);
    }
}
