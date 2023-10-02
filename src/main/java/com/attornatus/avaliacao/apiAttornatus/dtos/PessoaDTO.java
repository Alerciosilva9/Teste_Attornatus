package com.attornatus.avaliacao.apiAttornatus.dtos;

import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

public class PessoaDTO {
    @NotBlank(message = "Informe o Nome Da pessoa")
    private String nome;

    @NotBlank
    private String dataNascimento;




    public PessoaDTO(){
    }
    public PessoaDTO(Pessoa pessoa){
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
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


}
