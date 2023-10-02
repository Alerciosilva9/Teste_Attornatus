package com.attornatus.avaliacao.apiAttornatus.controllers;


import com.attornatus.avaliacao.apiAttornatus.dtos.PessoaDTO;
import com.attornatus.avaliacao.apiAttornatus.entities.Endereco;
import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import com.attornatus.avaliacao.apiAttornatus.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService service;

    @GetMapping
    public List<Pessoa> buscar(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable long id){
        Pessoa pessoa = service.buscarPessoa(id);
        if(pessoa!=null){
            return ResponseEntity.ok().body(pessoa);
        }
        return ResponseEntity.notFound().build();
    }
    /*
    @GetMapping("/{id}/endereco")
    public ResponseEntity<List<Endereco>> buscarEnderecos(@PathVariable long id){
        Pessoa pessoa = service.buscarPessoa(id);
        if(pessoa!=null){
            return ResponseEntity.ok().body(pessoa.getEndereco());
        }
        return ResponseEntity.notFound().build();
    }*/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa criarPessoa(@RequestBody  @Valid PessoaDTO pessoa){
        return service.criar(pessoa);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PessoaDTO> editarPessoa(@PathVariable long id, @RequestBody PessoaDTO pessoaDTO){
        PessoaDTO pessoa = service.editar(id,pessoaDTO);
        if(pessoa!=null){
            return ResponseEntity.ok().body(pessoa);
        }
        return ResponseEntity.notFound().build();
    }




}
