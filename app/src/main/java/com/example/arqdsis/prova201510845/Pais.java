package com.example.arqdsis.prova201510845;

import java.io.Serializable;

/**
 * Created by arqdsis on 05/05/2017.
 */
public class Pais implements Serializable {
    private String nome;
    private String capital;
    private String area;
    private String populacao;
    private String moeda;


    public Pais(String nome, String capital, String area, String populacao, String moeda) {
        this.nome = nome;
        this.capital = capital;
        this.area = area;
        this.populacao = populacao;
        this.moeda = moeda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pais pais = (Pais) o;

        return nome != null ? nome.equals(pais.nome) : pais.nome == null;

    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }

     public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getCapital() {

        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
