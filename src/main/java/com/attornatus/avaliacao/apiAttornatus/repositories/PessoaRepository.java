package com.attornatus.avaliacao.apiAttornatus.repositories;

import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}