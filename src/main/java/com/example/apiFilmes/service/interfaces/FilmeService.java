package com.example.apiFilmes.service.interfaces;

import com.example.apiFilmes.dto.FilmeDto;
import com.example.apiFilmes.dto.FilmeResponseDto;

import java.util.List;

public interface FilmeService {

    List<FilmeResponseDto> exibirTodosOsFilmes();

    FilmeResponseDto exibirFilmeById(Long id);

    FilmeResponseDto criarFilme(FilmeDto filmeDto);

    FilmeResponseDto atualizarFilme(Long id, FilmeDto filmeDto) ;

    void excluirFilme(Long id);

    FilmeResponseDto indicarFilmeSemAvaliacao();

    List<FilmeResponseDto> filtrarFilmesSemAvaliacao();
}
