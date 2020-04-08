/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.table;
import br.com.eeb.biblio.main.classes.Aluno;
import br.com.eeb.biblio.main.classes.Livro;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class TabelaInternal extends AbstractTableModel{
    String [] colunas = {"Nome do livro", "Nome do aluno", "Série do aluno", "Estado"};
    ArrayList<Aluno> dados = new ArrayList();
    private String nome;
    private Livro livro;
    
    public TabelaInternal(String nome, Livro l){
        this.nome = nome;
        this.livro = l;
        dados = livro.getAlunoEmprestou();
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return this.nome;
            case 1: return this.dados.get(rowIndex).getNome();
            case 2: return this.dados.get(rowIndex).getSerie();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 1:
                this.dados.get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                this.dados.get(rowIndex).setSerie((int) aValue);
                break;
        }
    }
}
