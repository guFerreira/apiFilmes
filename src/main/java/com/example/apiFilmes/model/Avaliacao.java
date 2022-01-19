package com.example.apiFilmes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int nota;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Filme filme;

}
