package com.attornatus.avaliacao.apiAttornatus.entities;

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
    private String numero;
    private String cidade;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="pessoa_id", referencedColumnName="id",nullable=false)
    private Pessoa pessoa;

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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