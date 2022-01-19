package com.example.apiFilmes.dto;

public class FilmeResponseDto {
    private String nome;
    private float avaliacaoMedia;

    public FilmeResponseDto() {

    }
    public FilmeResponseDto(String nome, float avaliacaoMedia) {
        this.nome = nome;
        this.avaliacaoMedia = avaliacaoMedia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public void setAvaliacaoMedia(float avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }
}
