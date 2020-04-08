/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.classes;

/**
 *
 * @author marco
 */
public class Aluno {
    private String nome;
    private int serie;

    public Aluno() {
    }

    public Aluno(String nome, int serie) {
        this.nome = nome;
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return nome+";"+serie;
    }
}
