package com.example.apiFilmes.exception;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class MensagemErro {
    private Instant timestamp;
    private Integer status;
    private String type;
    private List<String> message;
    private String path;

}
