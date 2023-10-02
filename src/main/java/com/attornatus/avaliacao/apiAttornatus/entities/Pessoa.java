package com.attornatus.avaliacao.apiAttornatus.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @NotBlank(message = "Informe o Nome Da pessoa")
    private String nome;
    @NotNull
    private String dataNascimento;

    @OneToMany(mappedBy="pessoa")
    private List<Endereco> enderecos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Endereco> getEndereco() {
        return this.enderecos;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.enderecos = endereco;
    }
}