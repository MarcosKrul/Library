/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.comparator;
import br.com.eeb.biblio.main.classes.Livro;
import java.util.Comparator;

/**
 *
 * @author marco
 */
public class BookComparator implements Comparator<Livro> {

    @Override
    public int compare(Livro o1, Livro o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
