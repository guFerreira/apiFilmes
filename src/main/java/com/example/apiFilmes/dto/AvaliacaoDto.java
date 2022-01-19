package com.example.apiFilmes.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor @Builder
public class AvaliacaoDto {
    @NotNull(message = "É necessário informar uma nota.")
    @Max(value = 5,message = "A nota máxima deve ser menor ou igual a 5.")
    @Min(value = 1, message = "A nota mínima deve ser maior ou igual a 1")
    private int nota;

    @NotNull(message = "O idFilme não pode ser nulo.")
    private Long idFilme;

}
