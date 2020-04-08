/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.file;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author marco
 */
public abstract class DirectoryControll {
    
    public static boolean directory (String name) throws IOException {
        File pattern = new File("C:\\");
        String[] list = pattern.list();
        for(String aux: list)
            if(aux.equals("Library"))
                return true;
        
        File dir = new File("C:\\Library\\main\\file");
        dir.mkdirs();
        File file = new File(name);
        return file.createNewFile();
    }
    
    public static boolean dirRestartBackup (String nome) {
        File dir = new File(nome);
        return dir.mkdir();
    }
}