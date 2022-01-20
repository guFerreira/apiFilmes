package com.example.apiFilmes.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class AvaliacaoDto {
    @NotNull(message = "{nota.not.null}")
    @Max(value = 5,message = "{nota.max}")
    @Min(value = 1, message = "{nota.min}")
    private int nota;

    @NotNull(message = "{nota.idFilme}")
    private Long idFilme;

}
