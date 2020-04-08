/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.classes;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Biblioteca {
    private ArrayList<Livro> biblioteca;

    public Biblioteca() {
    }

    public Biblioteca(ArrayList<Livro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public ArrayList<Livro> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(ArrayList<Livro> biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    public void addLivro(Livro l){
        this.biblioteca.add(l);
    }
    
    public boolean removeLivro(Livro l){
        return this.biblioteca.remove(l);
    }
    
    public Livro getLivroBiblio(int index){
        return this.biblioteca.get(index);
    }
}
