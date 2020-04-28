/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.exist;
import br.com.eeb.biblio.main.classes.Livro;
import br.com.eeb.biblio.main.table.TabelaMain;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public abstract class Exist {
    
    public static boolean existBook (Livro l) throws IllegalArgumentException {
        if(l == null ||  !(l instanceof Livro))
            throw new IllegalArgumentException();
        
        TabelaMain table = new TabelaMain();
        ArrayList<Livro> array = table.getDados();
        for(Livro aux : array){
            if (l.equals(aux)) return true;
        }
        return false;
    }
}
