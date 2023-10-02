package com.attornatus.avaliacao.apiAttornatus.controllers;

import com.attornatus.avaliacao.apiAttornatus.dtos.EnderecoDTO;
import com.attornatus.avaliacao.apiAttornatus.dtos.EnderecoPrincipalDTO;
import com.attornatus.avaliacao.apiAttornatus.entities.Endereco;
import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import com.attornatus.avaliacao.apiAttornatus.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa/{id}/endereco")
public class EnderecoController {
    @Autowired
    EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoDTO> criarEnderecos(@PathVariable long id, @RequestBody @Valid EnderecoDTO dto){
        EnderecoDTO endereco = service.salvar(id, dto);
        if(endereco!=null){
            return ResponseEntity.ok().body(endereco);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> buscarEnderecos(@PathVariable long id){
        List<EnderecoDTO> enderecos = service.buscarEnderecos(id);
        if(enderecos!=null){
            return ResponseEntity.ok().body(enderecos);
        }
        return ResponseEntity.notFound().build();
    }




}
