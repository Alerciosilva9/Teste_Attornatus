package com.attornatus.avaliacao.apiAttornatus.dtos;

import com.attornatus.avaliacao.apiAttornatus.entities.Endereco;
import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PessoaDetalhadoDTO {
    private String nome;
    private String dataNascimento;

    private List<Endereco> enderecos;

    private Endereco enderecoPrincipal;
    public PessoaDetalhadoDTO(){

    }
    public PessoaDetalhadoDTO(Pessoa pessoa){
        this.dataNascimento = pessoa.getDataNascimento();
        this.nome = pessoa.getNome();
        this.enderecos = pessoa.getEnderecos();
        this.enderecoPrincipal = pessoa.getEnderecoPrincipal();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Endereco getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }
}
