/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.CDD;
import br.com.eeb.biblio.file.FileControll;
import br.com.eeb.biblio.main.classes.Livro;
import br.com.eeb.biblio.main.table.TabelaMain;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author marco
 */
public abstract class CddControll {
    
    private static ArrayList<String> listaCdds;
    private static final String F_DIR = "C:\\Library\\main\\file\\regLab_EEBAB.txt";
    
    public static boolean existCdd (String cdd) {
        for(String aux: listaCdds)
            if(cdd.equalsIgnoreCase(aux)) return true;
        return false;
    }
    
    public static void addCdd(String cdd) {
        if(!existCdd(cdd))
            listaCdds.add(cdd);
    }

    public static ArrayList<String> getCdds (ArrayList<Livro> listaLivros) {
        listaCdds = new ArrayList<>();
        listaCdds.add("Nenhum");
        String teste;
        boolean verf;
        for(int i=0 ; i<listaLivros.size() ; i++){
            teste = listaLivros.get(i).getCdd();
            verf = true;
            for(String aux: listaCdds)
                if(aux.equalsIgnoreCase(teste)) verf = false;
            if(verf) listaCdds.add(teste);
        }
        return listaCdds;
    }
    
    public static void comboListener(JComboBox<String> main, JComboBox<String> sec, TabelaMain table) {
        main.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    try {
                        tableCdd(table, (String) main.getSelectedItem());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        return;
                    }
                    sec.setSelectedItem(main.getSelectedItem());
                }
            }
        });
    }
    
    public static void tableCdd (TabelaMain table, String cdd) throws IOException {
        table.setDados(FileControll.fread(F_DIR));
        if(cdd.equalsIgnoreCase("Nenhum"))
            return;
        
        ArrayList<Livro> novaLista = new ArrayList<>();
        for(Livro aux: table.getDados())
            if(aux.getCdd().equalsIgnoreCase(cdd))
                novaLista.add(aux);
        table.setDados(novaLista);
    }
    
    public static int indexFull (Livro l, TabelaMain table, String cdd) throws IOException {
        int rtn = -1;
        table.setDados2(FileControll.fread(F_DIR));
        for(int i=0 ; i<table.getDados().size() ; i++)
            if(table.getDados().get(i).equals(l))
                rtn = i;
        tableCdd(table, cdd);
        return rtn;
    }
}
