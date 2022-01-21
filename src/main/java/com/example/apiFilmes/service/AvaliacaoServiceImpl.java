package com.example.apiFilmes.service;

import com.example.apiFilmes.dto.AvaliacaoDto;
import com.example.apiFilmes.model.Avaliacao;
import com.example.apiFilmes.model.Filme;
import com.example.apiFilmes.repository.AvaliacaoRepository;
import com.example.apiFilmes.repository.FilmeRepository;
import com.example.apiFilmes.service.interfaces.AvaliacaoService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {
    private FilmeRepository filmeRepository;
    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoServiceImpl(FilmeRepository filmeRepository, AvaliacaoRepository avaliacaoRepository) {
        this.filmeRepository = filmeRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Override
    public Avaliacao avaliarFilme(AvaliacaoDto avaliacaoDto){
        Filme filme = filmeRepository.findById(avaliacaoDto.getIdFilme())
                .orElseThrow(()-> new EntityNotFoundException("Não foi encontrado a entidade Filme com o id "+avaliacaoDto.getIdFilme()));

        Avaliacao avaliacao = Avaliacao.builder()
                .nota(avaliacaoDto.getNota())
                .filme(filme)
                .build();

        filme.getAvaliacoes().add(avaliacao);
        return avaliacaoRepository.save(avaliacao);
    }


}
