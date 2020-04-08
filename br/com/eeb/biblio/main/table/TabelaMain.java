/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.table;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import br.com.eeb.biblio.main.classes.Livro;
/**
 *
 * @author marco
 */
public class TabelaMain extends AbstractTableModel{

    String[] colunas = {"Nome", "Editora", "Páginas", "Unidades disponíveis", "Em estoque"};
    ArrayList<Livro> dados = new ArrayList<>();
    
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
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return this.dados.get(rowIndex).getNome();
            case 1: return this.dados.get(rowIndex).getEditora();
            case 2: return this.dados.get(rowIndex).getPaginas();
            case 3: return this.dados.get(rowIndex).getQuantidadeDisponivel();
            case 4: return this.dados.get(rowIndex).getQuantidadeEstoque();
        }
        return null;
    }

    @Override
    public void setValueAt(Object livro, int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: 
                this.dados.get(rowIndex).setNome((String) livro);
                break;
            case 1: 
                this.dados.get(rowIndex).setEditora((String) livro);
                break;
            case 2: 
                this.dados.get(rowIndex).setPaginas((int) livro);
                break;
            case 3:
                this.dados.get(rowIndex).setQuantidadeDisponivel((int) livro);
                break;
            case 4:
                this.dados.get(rowIndex).setQuantidadeEstoque((int) livro);
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public Livro livroControle(int row){
        return this.dados.get(row);
    }
    
    public int buscaLivro(String nome){
        int index = 0;
        for(Livro aux: this.dados){
            if(aux.getNome().equals(nome))
                return index;
            else index++;
        }
        return -1;
    }
    
    public void addRow(Livro l){
        this.dados.add(l);
        this.fireTableDataChanged();
    }

    public void removeRow(int row){
        this.dados.remove(row);
        this.fireTableRowsDeleted(row, row);
    }

    public ArrayList<Livro> getDados() {
        return dados;
    }

    public void setDados(ArrayList<Livro> dados) {
        this.dados = dados;
    }
    
    public int qntEstoque () {
        int soma = 0;
        for(Livro aux: dados)
            soma += aux.getQuantidadeEstoque();
        return soma;
    }
    
    public int qntDisponivel () {
        int soma = 0;
        for(Livro aux: dados)
            soma += (aux.getQuantidadeEstoque() - aux.getQuantidadeDisponivel());
        return soma;
    }
}
