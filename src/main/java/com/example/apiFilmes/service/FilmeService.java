package com.example.apiFilmes.service;

import com.example.apiFilmes.dto.AvaliacaoDto;
import com.example.apiFilmes.dto.FilmeDto;
import com.example.apiFilmes.dto.FilmeResponseDto;
import com.example.apiFilmes.model.Avaliacao;
import com.example.apiFilmes.model.Filme;
import com.example.apiFilmes.repository.AvaliacaoRepository;
import com.example.apiFilmes.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class FilmeService {
    private FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<FilmeResponseDto> exibirTodosOsFilmes() {
        List<Filme> filmes = filmeRepository.findAll();
        this.filtrarFilmesSemAvaliacao();
        return filmes
                .stream()
                .map(filme -> new FilmeResponseDto(filme.getNome(), this.calcularMediaAvaliacao(filme.getId())))
                .collect(Collectors.toList());
    }

    public FilmeResponseDto exibirFilmeById(Long idFilme) {
        Filme filme = filmeRepository.getById(idFilme);
        return new FilmeResponseDto(filme.getNome(), this.calcularMediaAvaliacao(idFilme));
    }

    public Filme criarFilme(FilmeDto filmeDto) {
        Filme filme = new Filme();
        filme.setNome(filmeDto.getNome());

        return filmeRepository.save(filme);
    }

    public Filme atualizarFilme(Long idFilme, FilmeDto filmeDto) {
        Filme filme = filmeRepository.getById(idFilme);
        filme.setNome(filmeDto.getNome());

        return filmeRepository.save(filme);
    }

    public void excluirFilme(Long idFilme) {
        filmeRepository.deleteById(idFilme);
    }


}
