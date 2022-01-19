package com.example.apiFilmes.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @Builder
public class FilmeResponseDto {
    private String nome;
    private float avaliacaoMedia;

    public FilmeResponseDto(String nome, float avaliacaoMedia) {
        this.nome = nome;
        this.avaliacaoMedia = avaliacaoMedia;
    }

}
