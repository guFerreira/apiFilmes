package com.example.apiFilmes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "É necessário informar uma nota.")
    @Max(value = 5,message = "A nota máxima deve ser menor ou igual a 5.")
    @Min(value = 1, message = "A nota mínima deve ser maior ou igual a 1")
    private int nota;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Filme filme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}
