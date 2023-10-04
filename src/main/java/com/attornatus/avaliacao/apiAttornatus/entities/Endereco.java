package com.attornatus.avaliacao.apiAttornatus.entities;

import com.attornatus.avaliacao.apiAttornatus.dtos.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String logradouro;
    private String cep;
    private long numero;
    private String cidade;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="pessoa_id", referencedColumnName="id",nullable=false)
    private Pessoa pessoa;

    public Endereco(){

    }

    public Endereco(EnderecoDTO dto){
        this.logradouro = dto.getLogradouro();
        this.cidade = dto.getCidade();
        this.numero = dto.getNumero();
        this.cep = dto.getCep();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}