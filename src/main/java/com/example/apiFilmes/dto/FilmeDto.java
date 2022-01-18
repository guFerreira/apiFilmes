package com.example.apiFilmes.dto;

import javax.validation.constraints.NotBlank;

public class FilmeDto {

    @NotBlank(message = "É necessário informar um nome ao filme.")
    private String nome;

    public FilmeDto() {
    }
    public FilmeDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
