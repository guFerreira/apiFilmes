package com.example.apiFilmes.controller;

import com.example.apiFilmes.dto.AvaliacaoDto;
import com.example.apiFilmes.dto.FilmeDto;
import com.example.apiFilmes.model.Avaliacao;
import com.example.apiFilmes.model.Filme;
import com.example.apiFilmes.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {

    private FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping
    public ResponseEntity<Filme> criarFilme(@RequestBody FilmeDto filmeDto){
        Filme novoFilme = this.filmeService.criarFilme(filmeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFilme);
    }

    @PutMapping("/{idFilme}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long idFilme, @RequestParam FilmeDto filmeDto){
        //Filme filmeAtualizado = filmeService.atualizarFilme(Lon)
        return null;
    }


}
