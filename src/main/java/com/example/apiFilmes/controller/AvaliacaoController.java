package com.example.apiFilmes.controller;

import com.example.apiFilmes.dto.AvaliacaoDto;
import com.example.apiFilmes.model.Avaliacao;
import com.example.apiFilmes.service.AvaliacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoController {

    AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping("/filme")
    public ResponseEntity<Avaliacao> avaliarFilme(@RequestBody AvaliacaoDto avaliacaoDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.avaliarFilme(avaliacaoDto));
    }

}
