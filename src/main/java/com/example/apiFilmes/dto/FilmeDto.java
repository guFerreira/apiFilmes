package com.example.apiFilmes.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class FilmeDto {

    @NotBlank(message = "{filme.not.blank}")
    private String nome;

}
