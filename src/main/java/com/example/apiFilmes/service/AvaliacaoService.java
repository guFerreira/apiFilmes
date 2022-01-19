package com.example.apiFilmes.service;

import com.example.apiFilmes.dto.AvaliacaoDto;
import com.example.apiFilmes.model.Avaliacao;
import com.example.apiFilmes.model.Filme;
import com.example.apiFilmes.repository.AvaliacaoRepository;
import com.example.apiFilmes.repository.FilmeRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {
    private FilmeRepository filmeRepository;
    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(FilmeRepository filmeRepository, AvaliacaoRepository avaliacaoRepository) {
        this.filmeRepository = filmeRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public Avaliacao avaliarFilme(AvaliacaoDto avaliacaoDto){
        Filme filme = filmeRepository.getById(avaliacaoDto.getIdFilme());

        Avaliacao avaliacao = Avaliacao.builder()
                .nota(avaliacaoDto.getNota())
                .filme(filme)
                .build();

        filme.getAvaliacoes().add(avaliacao);
        return avaliacaoRepository.save(avaliacao);
    }
}
