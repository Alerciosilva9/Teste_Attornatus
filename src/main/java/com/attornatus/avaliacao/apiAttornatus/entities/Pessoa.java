package com.attornatus.avaliacao.apiAttornatus.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String nome;
    private String dataNascimento;

    @OneToMany(mappedBy="pessoa")
    private List<Endereco> endereco;

}