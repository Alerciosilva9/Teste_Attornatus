package com.attornatus.avaliacao.apiAttornatus.services;

import com.attornatus.avaliacao.apiAttornatus.dtos.EnderecoDTO;
import com.attornatus.avaliacao.apiAttornatus.dtos.PessoaDTO;
import com.attornatus.avaliacao.apiAttornatus.entities.Endereco;
import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import com.attornatus.avaliacao.apiAttornatus.repositories.EnderecoRepository;
import com.attornatus.avaliacao.apiAttornatus.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository repository;

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Endereco> buscar(long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            return pessoa.get().getEndereco();
        }
        return null;
    }

    public EnderecoDTO salvar(long id, EnderecoDTO dto){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            Endereco endereco = new Endereco(dto);
            endereco.setPessoa(pessoa.get());
            return new EnderecoDTO(repository.save(endereco));
        }
        return null;
    }

    public List<EnderecoDTO> buscarEnderecos(long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            List<Endereco> enderecos = pessoa.get().getEndereco();
            return enderecos.stream().map(r -> new EnderecoDTO(r)).collect(Collectors.toList());
        }
        return null;
    }

}
