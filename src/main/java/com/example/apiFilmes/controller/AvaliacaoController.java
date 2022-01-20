package com.example.apiFilmes.controller;

import com.example.apiFilmes.dto.AvaliacaoDto;
import com.example.apiFilmes.model.Avaliacao;
import com.example.apiFilmes.service.interfaces.AvaliacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoController {

    AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping("/filme")
    public ResponseEntity<Avaliacao> avaliarFilme(@Valid @RequestBody AvaliacaoDto avaliacaoDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.avaliarFilme(avaliacaoDto));
    }

}
