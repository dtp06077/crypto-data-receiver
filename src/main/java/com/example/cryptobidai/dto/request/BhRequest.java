package com.example.cryptobidai.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class BhRequest {
    String ticket;
    String type;
    List<String> codes;
    String format;
}
