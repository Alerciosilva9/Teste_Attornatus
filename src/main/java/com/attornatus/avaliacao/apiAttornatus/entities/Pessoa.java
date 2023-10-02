package com.attornatus.avaliacao.apiAttornatus.entities;

import com.attornatus.avaliacao.apiAttornatus.dtos.PessoaDTO;
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

    private String nome;

    private String dataNascimento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_principal", referencedColumnName = "id",nullable=true)
    private Endereco enderecoPrincipal;
    @OneToMany(mappedBy="pessoa")
    private List<Endereco> enderecos;



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

    public Pessoa(){

    }
    public Pessoa(PessoaDTO dto){
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDataNascimento();
    }

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