package com.web3.peconsult.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidato_2014_pe")
public class Candidato {

    @Id
    private Long id;
    @Column(name = "NM_CANDIDATO")
    private String nome;

    @Column(name = "SG_PARTIDO")
    private String partido;

    @Column(name = "ANO_ELEICAO")
    private Integer ano;

    @Column(name = "DS_CARGO")
    private String cargo;


    public Candidato() {

    }

    public Candidato(Long id, String nome, String partido, Integer ano, String cargo) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.ano = ano;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
