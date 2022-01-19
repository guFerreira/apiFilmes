package com.example.apiFilmes.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy="filme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacoes;

}
