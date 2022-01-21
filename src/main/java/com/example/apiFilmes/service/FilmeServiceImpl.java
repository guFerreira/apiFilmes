package com.example.apiFilmes.service;


import com.example.apiFilmes.dto.FilmeDto;
import com.example.apiFilmes.dto.FilmeResponseDto;
import com.example.apiFilmes.model.Filme;
import com.example.apiFilmes.repository.AvaliacaoRepository;
import com.example.apiFilmes.repository.FilmeRepository;
import com.example.apiFilmes.service.interfaces.FilmeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Service
public class FilmeServiceImpl implements FilmeService {
    private FilmeRepository filmeRepository;
    private AvaliacaoRepository avaliacaoRepository;

    public FilmeServiceImpl(FilmeRepository filmeRepository, AvaliacaoRepository avaliacaoRepository) {
        this.filmeRepository = filmeRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Override
    public List<FilmeResponseDto> exibirTodosOsFilmes() {
        List<Filme> filmes = filmeRepository.findAll();
        this.filtrarFilmesSemAvaliacao();
        return filmes
                .stream()
                .map(filme -> new FilmeResponseDto(filme.getNome(), this.calcularMediaAvaliacao(filme.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public FilmeResponseDto exibirFilmeById(Long id) {
        Filme filme = this.buscarFilmePorId(id);
        return new FilmeResponseDto(filme.getNome(), this.calcularMediaAvaliacao(id));
    }

    @Override
    public FilmeResponseDto criarFilme(FilmeDto filmeDto) {
        Filme filme = Filme.builder().nome(filmeDto.getNome()).build();
        filmeRepository.save(filme);
        return new FilmeResponseDto(filme.getNome(), 0);
    }

    @Override
    public FilmeResponseDto atualizarFilme(Long id, FilmeDto filmeDto) {
        Filme filme = this.buscarFilmePorId(id);
        filme.setNome(filmeDto.getNome());

        return new FilmeResponseDto(filme.getNome(), this.calcularMediaAvaliacao(id));

    }

    @Override
    public void excluirFilme(Long id) {
        buscarFilmePorId(id);
        filmeRepository.deleteById(id);
    }

    private float calcularMediaAvaliacao(Long id) {
        return avaliacaoRepository.getMediaAvaliacaoByFilmeId(id);
    }

    @Override
    public FilmeResponseDto indicarFilmeSemAvaliacao() {
        Random random = new Random();
        List<FilmeResponseDto> filmes = this.filtrarFilmesSemAvaliacao();
        return filmes.get(random.nextInt(filmes.size()));
    }

    @Override
    public List<FilmeResponseDto> filtrarFilmesSemAvaliacao() {
        List<Filme> filmes = filmeRepository.findAll();

        List<FilmeResponseDto> filmeResponseDtos = filmes
                .stream()
                .map(filme -> new FilmeResponseDto(filme.getNome(), this.calcularMediaAvaliacao(filme.getId())))
                .filter(filmeResponseDto -> filmeResponseDto.getAvaliacaoMedia() == 0.0)
                .collect(Collectors.toList());
        return filmeResponseDtos;
    }

    private Filme buscarFilmePorId(Long id){
        String mensagem = "Não foi encontrado a entidade Filme com o id "+ id;
        return this.filmeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(mensagem));

    }

}
