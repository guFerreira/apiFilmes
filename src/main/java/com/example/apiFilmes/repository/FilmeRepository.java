package com.example.apiFilmes.repository;

import com.example.apiFilmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FilmeRepository extends JpaRepository<Filme,Long> {
}
