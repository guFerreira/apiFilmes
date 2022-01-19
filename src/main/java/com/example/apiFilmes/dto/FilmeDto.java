package com.example.apiFilmes.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class FilmeDto {

    @NotBlank(message = "É necessário informar um nome ao filme.")
    private String nome;

}
