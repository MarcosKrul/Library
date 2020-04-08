/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.file;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public abstract class FileHelp {
    
    private static final String DIR = "src\\main\\java\\br\\com\\eeb\\biblio\\file\\about\\";
    
    public static boolean creat (String name) throws IOException {
        File arq = new File(DIR+name);
        if (arq.exists()) return true;
        return arq.createNewFile();
    }

    public static ArrayList<String> read (String name) throws IOException {
        if(!creat(name))
            return null;
        ArrayList<String> rtn = new ArrayList<>();
        String linha;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(DIR+name), "UTF8"))){
            while((linha = bf.readLine()) != null)
                rtn.add(linha);
        }
        return rtn;
    }

}

