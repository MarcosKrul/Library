/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.enumeration;

/**
 *
 * @author marco
 */
public enum EstadoLivro {
    EMPRESTADO(1, "Emprestado"), 
    DISPONIVEL(2, "Disponível"), 
    INDISPONIVEL(3, "Fora de estoque");
    
    private int estado;
    private String nomeEstado;
    private EstadoLivro(int estado, String nome) {
        this.estado = estado;
        this.nomeEstado = nome;
    }
    
    public String getNomeEstado(){
        return this.nomeEstado;
    }
}
