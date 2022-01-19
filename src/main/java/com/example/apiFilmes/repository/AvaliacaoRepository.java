package com.example.apiFilmes.repository;

import com.example.apiFilmes.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {
    @Query(value = "SELECT coalesce(AVG(avaliacao.nota),0) " +
                    "FROM Avaliacao avaliacao " +
                    "WHERE avaliacao.filme.id = :idFilme")
    public float getMediaAvaliacaoByFilmeId(@Param("idFilme") Long idFilme);

}
