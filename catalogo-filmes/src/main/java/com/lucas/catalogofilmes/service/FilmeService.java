package com.lucas.catalogofilmes.service;

import com.lucas.catalogofilmes.entity.Filme;
import com.lucas.catalogofilmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Filme salvarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }
    public Filme retorneFilme(Long id){
        Optional<Filme> optionalFilme = filmeRepository.findById(id);
        return optionalFilme.orElse(null);
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public Filme atualizarFilme(Long id, Filme filme) {
        Filme filmeExistente = filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filmeExistente.getTitulo();
        filmeExistente.getGenero();
        filmeExistente.getDiretor();
        filmeExistente.getAno();
        filmeExistente.getAvaliacao();
        filmeExistente.isAvaliado();
        return filmeRepository.save(filmeExistente);
    }

    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }

    public List<Filme> listarFilmesNaoAvaliado() {
        return filmeRepository.findByAvaliadoFalse();
    }

}