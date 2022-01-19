package com.example.apiFilmes.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class FilmeResponseDto {
    private String nome;
    private float avaliacaoMedia;

}
