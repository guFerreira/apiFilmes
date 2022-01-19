package com.example.apiFilmes.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor @Builder
public class FilmeDto {

    @NotBlank(message = "É necessário informar um nome ao filme.")
    private String nome;

}
