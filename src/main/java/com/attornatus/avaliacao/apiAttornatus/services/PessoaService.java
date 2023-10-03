package com.attornatus.avaliacao.apiAttornatus.services;

import com.attornatus.avaliacao.apiAttornatus.dtos.PessoaDTO;
import com.attornatus.avaliacao.apiAttornatus.dtos.PessoaDetalhadoDTO;
import com.attornatus.avaliacao.apiAttornatus.entities.Endereco;
import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import com.attornatus.avaliacao.apiAttornatus.repositories.EnderecoRepository;
import com.attornatus.avaliacao.apiAttornatus.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PessoaService {
    @Autowired
    PessoaRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    public List<PessoaDTO> buscarTodos(){
        return repository.findAll().stream().map(r -> new PessoaDTO(r)).collect(Collectors.toList());
    }

    public PessoaDetalhadoDTO buscarPessoa(long id) {
        Optional<Pessoa> pessoa = repository.findById(id);

        if(pessoa.isPresent()){
            System.out.println(pessoa.get().getEnderecoPrincipal());
            return new PessoaDetalhadoDTO(pessoa.get());
        }
        return null;
    }

    public Pessoa criar(PessoaDTO dto){
        Pessoa novaPessoa = new Pessoa(dto);
        return repository.save(novaPessoa);
    }
    public PessoaDTO editar(long id, PessoaDTO dto){
        Optional<Pessoa> pessoa = repository.findById(id);
        if(pessoa.isPresent()){
            if(dto.getNome()!=null)pessoa.get().setNome(dto.getNome());
            if(dto.getDataNascimento()!=null) pessoa.get().setDataNascimento(dto.getDataNascimento());
            return new PessoaDTO(repository.save(pessoa.get()));
        }
        return null;

    }

    public Boolean atualizarPrincipal(long id,long id_endereco){
        Optional<Pessoa> pessoa = repository.findById(id);
        Optional<Endereco> endereco = enderecoRepository.findById(id_endereco);
        if(pessoa.isPresent() && endereco.isPresent()){
            pessoa.get().setEnderecoPrincipal(endereco.get());
            repository.save(pessoa.get());
            return true;
        }
        return false;
    }
}
