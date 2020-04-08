/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.classes;
import br.com.eeb.biblio.main.interfaces.Cambiavel;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Livro implements Cambiavel {
    private String nome;
    private String editora;
    private int paginas;
    private int quantidadeEstoque;
    private int quantidadeDisponivel;
    private ArrayList<Aluno> alunoEmprestou;
    
    public Livro() {
    }

    public Livro(String nome, String editora, int qEst, int qDis, int qntPaginas) {
        this.nome = nome;
        this.editora = editora;
        this.paginas = qntPaginas;
        this.quantidadeEstoque = qEst;
        this.quantidadeDisponivel = qDis;
        this.alunoEmprestou = new ArrayList<>();
    }

    @Override
    public boolean devolucao(Aluno a) {
        boolean achou = false;
        int i = 0;
        if(this.quantidadeDisponivel < this.quantidadeEstoque){
            while(i < (this.quantidadeEstoque-this.quantidadeDisponivel) && !achou){
                Aluno teste = this.alunoEmprestou.get(i);
                if(teste.getNome().equals(a.getNome()) && teste.getSerie() == a.getSerie()) {
                    achou = true;
                    this.quantidadeDisponivel++;
                    this.alunoEmprestou.remove(i);
                } else i++;
            }
        }
        return achou;
    }

    @Override
    public boolean emprestimo(Aluno a) {
        if(this.quantidadeDisponivel>0){
            this.alunoEmprestou.add(a);
            this.quantidadeDisponivel--;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.nome.equals(((Livro)obj).getNome()) && 
           this.editora.equals(((Livro)obj).getEditora()) &&
           this.paginas == ((Livro)obj).getPaginas() &&
           this.quantidadeEstoque == ((Livro)obj).getQuantidadeEstoque())
           return true;
        
        return false;
    }
    
    @Override
    public String toString() {
        String alunos;
        if(alunoEmprestou.isEmpty())
            alunos = null;
        else{
            if(alunoEmprestou.size() == 1)
                alunos = alunoEmprestou.get(0).toString();
            else alunos = alunoEmprestou.get(0).toString()+";";
            for(int i=1 ; i<alunoEmprestou.size() ; i++) {
                if(i == alunoEmprestou.size()-1)
                    alunos += alunoEmprestou.get(i).toString();
                else alunos += alunoEmprestou.get(i).toString()+";";
            }
        }
        return nome+";"+editora+";"+quantidadeEstoque+";"+quantidadeDisponivel+";"+paginas+";"+alunos;
    }
    
    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Aluno getAlunoEmprestou(int index) {
        return this.alunoEmprestou.get(index);
    }

    public ArrayList<Aluno> getAlunoEmprestou() {
        return alunoEmprestou;
    }
    
    public void setAlunoEmprestou(Aluno alunoEmprestou) {
        this.alunoEmprestou.add(alunoEmprestou);
    }
}