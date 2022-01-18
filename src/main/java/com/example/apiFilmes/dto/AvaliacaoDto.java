package com.example.apiFilmes.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AvaliacaoDto {
    @NotNull(message = "É necessário informar uma nota.")
    @Max(value = 5,message = "A nota máxima deve ser menor ou igual a 5.")
    @Min(value = 1, message = "A nota mínima deve ser maior ou igual a 1")
    private int nota;

    @NotNull(message = "O idFilme não pode ser nulo.")
    private Long idFilme;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }
}
