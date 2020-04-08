/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.imagensControll;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author marco
 */
public class imagensControll extends javax.swing.JPanel {
    
    private ImageIcon img;

    public imagensControll() {
        this.img = new ImageIcon();
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
