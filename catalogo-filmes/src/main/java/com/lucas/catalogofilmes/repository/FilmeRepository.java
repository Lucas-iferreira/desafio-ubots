package com.lucas.catalogofilmes.repository;

import com.lucas.catalogofilmes.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByAvaliadoFalse();
}
