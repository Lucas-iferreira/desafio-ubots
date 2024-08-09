package com.lucas.catalogofilmes.controller;

import com.lucas.catalogofilmes.entity.Filme;
import com.lucas.catalogofilmes.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme){
        return filmeService.salvarFilme(filme);
    }

    @GetMapping
    public List<Filme> listarFilmes(){
        return filmeService.listarFilmes();
    }

    @GetMapping("/filme-escolhido/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable Long id){
        Filme filme = filmeService.retorneFilme(id);
        if(filme != null){
            return ResponseEntity.ok(filme);
        } else{
            return  ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme filme){
        return filmeService.atualizarFilme(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(Long id){
        filmeService.deletarFilme(id);
    }

    @GetMapping("/nao-avaliados")
    public List<Filme> listarFilmesNaoAvaliados(){
        return filmeService.listarFilmesNaoAvaliado();
    }
}
