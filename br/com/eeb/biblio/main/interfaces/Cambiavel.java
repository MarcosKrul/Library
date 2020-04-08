/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.interfaces;
import br.com.eeb.biblio.main.classes.Aluno;

/**
 *
 * @author marco
 */
public interface Cambiavel {
    public boolean devolucao(Aluno a);
    public boolean emprestimo(Aluno a);
}
