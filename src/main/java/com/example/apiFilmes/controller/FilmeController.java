package com.example.apiFilmes.controller;

import com.example.apiFilmes.dto.FilmeDto;
import com.example.apiFilmes.dto.FilmeResponseDto;
import com.example.apiFilmes.service.FilmeServiceImpl;
import com.example.apiFilmes.service.interfaces.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {

    private FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponseDto>> exibirTodosOsFilmes(){
        return ResponseEntity.ok(filmeService.exibirTodosOsFilmes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponseDto> exibirFilmeById(@PathVariable Long id){
        return ResponseEntity.ok(filmeService.exibirFilmeById(id));
    }

    @GetMapping("/sem-avaliacao")
    public ResponseEntity<List<FilmeResponseDto>> exibirTodosOsFilmesSemAvaliacao(){
        return ResponseEntity.ok(filmeService.filtrarFilmesSemAvaliacao());
    }

    @GetMapping("/recomendacao")
    public ResponseEntity<FilmeResponseDto> recomendarFilmeSemAvaliacao(){
        return ResponseEntity.ok(filmeService.indicarFilmeSemAvaliacao());
    }

    @PostMapping
    public ResponseEntity<FilmeResponseDto> criarFilme(@RequestBody FilmeDto filmeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.filmeService.criarFilme(filmeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeResponseDto> atualizarFilme(@PathVariable Long id, @RequestBody FilmeDto filmeDto){
        return ResponseEntity.ok(filmeService.atualizarFilme(id, filmeDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void excluirFilme(@PathVariable Long id){
        filmeService.excluirFilme(id);
    }


}
