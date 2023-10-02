package com.attornatus.avaliacao.apiAttornatus.entities;

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
    @JoinColumn(name="pessoa_id", referencedColumnName="id",nullable=false)
    private Pessoa pessoa;



}