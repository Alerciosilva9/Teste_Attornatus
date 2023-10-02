package com.attornatus.avaliacao.apiAttornatus.services;

import com.attornatus.avaliacao.apiAttornatus.dtos.PessoaDTO;
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

    public Pessoa criar(PessoaDTO dto){
        Pessoa novaPessoa = new Pessoa(dto);
        return repository.save(novaPessoa);
    }
    public PessoaDTO editar(long id, PessoaDTO dto){
        Optional<Pessoa> pessoa = repository.findById(id);
        System.out.println("Editando para "+id+"com dto"+dto.getNome()+dto.getDataNascimento());
        if(pessoa.isPresent()){
            if(dto.getNome()!=null)pessoa.get().setNome(dto.getNome());
            if(dto.getDataNascimento()!=null) pessoa.get().setDataNascimento(dto.getDataNascimento());

            System.out.println(pessoa.get().getNome() + pessoa.get().getDataNascimento());
            return new PessoaDTO(repository.save(pessoa.get()));
        }
        return null;

    }
}
