package com.example.apiFilmes.service.interfaces;

import com.example.apiFilmes.dto.AvaliacaoDto;
import com.example.apiFilmes.model.Avaliacao;
import com.example.apiFilmes.model.Filme;

public interface AvaliacaoService {
    public Avaliacao avaliarFilme(AvaliacaoDto avaliacaoDto);
}
