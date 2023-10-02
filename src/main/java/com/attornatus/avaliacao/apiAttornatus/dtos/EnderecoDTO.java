package com.attornatus.avaliacao.apiAttornatus.dtos;

import com.attornatus.avaliacao.apiAttornatus.entities.Endereco;
import com.attornatus.avaliacao.apiAttornatus.entities.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class EnderecoDTO {
    @NotEmpty
    private String logradouro;
    @NotEmpty
    private String cep;
    @NotEmpty
    private String numero;
    @NotEmpty
    private String cidade;





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
    public EnderecoDTO(){

    }
    public EnderecoDTO(Endereco endereco){
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();

    }

}
