/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.file;
import br.com.eeb.biblio.main.classes.Livro;
import br.com.eeb.biblio.main.classes.Aluno;
import br.com.eeb.biblio.main.comparator.BookComparator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author marco
 */
public abstract class FileControll {
    
    private static ArrayList<Livro> lista;
    private static final String NAME = "\\regLab_EEBAB.txt";

    public static boolean fwrite (String conteudo, String fileName, boolean app) throws IOException{
        if(!DirectoryControll.directory(fileName))
            return false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName), app))) {
                bw.write(conteudo);
                bw.newLine();
                bw.flush();
                return true;
        }
    }
 
    public static ArrayList<Livro> fread(String fileName) throws IOException{
        if(!DirectoryControll.directory(fileName))
            return null;
        ArrayList<Livro> list = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(new File(fileName)))) {
            String linha;
            String[] atributos;
            Livro l;
            while((linha = bf.readLine()) != null){
                atributos = linha.split(";");
                String nome = atributos[0];
                String editora = atributos[1];
                int qEst = Integer.parseInt(atributos[2]);
                int qDis = Integer.parseInt(atributos[3]);
                int pg = Integer.parseInt(atributos[4]);
                String cdd = atributos[5];
                l = new Livro(nome, editora, cdd, qEst, qDis, pg);
                for(int i=6 ; i<atributos.length ; i+=2)
                    if(!atributos[i].equals("null")){
                        Aluno a;
                        String nomeA = atributos[i];
                        int serie = Integer.parseInt(atributos[i+1]);
                        a = new Aluno(nomeA, serie);
                        l.setAlunoEmprestou(a);
                    }
                list.add(l);
            }
        }
        Collections.sort(list, new BookComparator());
        return list;
    }
    
    public static void attChange (Livro l, String name, int index) throws IOException {
        if(!DirectoryControll.directory(name))
            return;
        ArrayList<Livro> lista = fread(name);
        lista.set(index, l);
        fwrite(lista.get(0).toString(), name, false);
        for(int i=1 ; i<lista.size() ; i++)
            fwrite(lista.get(i).toString(), name, true);
    }
  
    public static void attDelte (String name, int index) throws IOException {
        lista = fread(name);
        lista.remove(index);
        if(lista.isEmpty()){
            File dir = new File(name);
            dir.delete();
            dir.createNewFile();
            return;
        }
        fwrite(lista.get(0).toString(), name, false);
        for(int i=1 ; i<lista.size() ; i++)
            fwrite(lista.get(i).toString(), name, true);
    }
    
    public static void backup (String dirName, String fileName) throws IOException {
        long inicio = System.currentTimeMillis();
        if(!DirectoryControll.dirRestartBackup(dirName))
            return;
        Path source = Paths.get(fileName);
        Path target = Paths.get(dirName+NAME);
        Files.copy(source, target);
        long fim = System.currentTimeMillis();
        System.out.println((fim-inicio)+"ms");
    }
    
    public static void restart (String dirName, String fileName) throws IOException {
        backup(dirName, fileName);
        File old = new File(fileName);
        old.delete();
        old.createNewFile();
    }
    
    public static String[] files () {
        File pattern = new File("C:\\Library");
        String[] list = pattern.list();
        ArrayList<String> rtn = new ArrayList<>();
        for(int i=0 ; i<list.length ; i++)
            if(list[i].contains("backup_"))
                rtn.add(list[i]);
        return rtn.toArray(new String[rtn.size()]);
    }
    
    public static void recuperarBackup (String nome, String principal) throws IOException{
        File dir = new File(nome);
        if(!dir.exists())
            return;
        
        Path source = Paths.get(nome+NAME);
        Path target = Paths.get(principal);
        Files.copy(source, target, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    }
}