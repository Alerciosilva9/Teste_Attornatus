package com.attornatus.avaliacao.apiAttornatus.repositories;

import com.attornatus.avaliacao.apiAttornatus.entities.Endereco;
import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {


    List<Endereco> findAllByPessoa(Pessoa pessoa);
    Endereco findByIdAndPessoa(long Id, Pessoa pessoa);



}