package com.attornatus.avaliacao.apiAttornatus.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    private String nome;
    private String dataNascimento;

    @OneToOne
    private Endereco endereco;

}