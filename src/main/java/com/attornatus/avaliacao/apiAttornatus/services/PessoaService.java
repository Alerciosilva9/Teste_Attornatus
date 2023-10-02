package com.attornatus.avaliacao.apiAttornatus.services;

import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import com.attornatus.avaliacao.apiAttornatus.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PessoaService {
    @Autowired
    PessoaRepository repository;

    public List<Pessoa> buscarTodos(){
        return repository.findAll();
    }

    public Pessoa buscarPessoa(long id) {
        Optional<Pessoa> pessoa = repository.findById(id);

        if(pessoa.isPresent()){
            return pessoa.get();
        }
        return null;
    }

    public Pessoa criar(Pessoa pessoa){
        return repository.save(pessoa);
    }
}
