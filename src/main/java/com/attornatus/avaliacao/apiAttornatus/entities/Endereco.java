package com.attornatus.avaliacao.apiAttornatus.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    private long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;



}