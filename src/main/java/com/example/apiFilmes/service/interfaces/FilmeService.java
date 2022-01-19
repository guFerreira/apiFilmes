package com.example.apiFilmes.service.interfaces;

import com.example.apiFilmes.dto.FilmeDto;
import com.example.apiFilmes.dto.FilmeResponseDto;

import java.util.List;

public interface FilmeService {

    public List<FilmeResponseDto> exibirTodosOsFilmes();

    public FilmeResponseDto exibirFilmeById(Long id);

    public FilmeResponseDto criarFilme(FilmeDto filmeDto);

    public FilmeResponseDto atualizarFilme(Long id, FilmeDto filmeDto) ;

    public void excluirFilme(Long id);

    public FilmeResponseDto indicarFilmeSemAvaliacao();

    public List<FilmeResponseDto> filtrarFilmesSemAvaliacao();
}
