/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Exemple de classe carte
 *
 * @author guillaume.laurent
 */
public class Carte {

    private int largeur = 20;
    private int hauteur = 15;
    private int tailleTuile = 32;
    
    private BufferedImage uneTuile;

    public Carte() {
        
    }

    public void miseAJour() {

    }
    public void rendu(Graphics2D contexte) {
        try {
            BufferedImage tileset = ImageIO.read(getClass().getResource("images/tileSetMinecraft32x32.png"));
            BufferedImage uneTuile = tileset.getSubimage(0, 0, tailleTuile, tailleTuile);
            contexte.drawImage(uneTuile, 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(Carte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void rendu(Graphics2D contexte, String nomFichier) throws FileNotFoundException {
        int i = 0;
        Integer[][] map;
        map = new Integer[1][1];
        try {
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier + ".txt"));

            while (fichier.ready()) {
                String ligne_texte;
                ligne_texte = fichier.readLine();
                if(i>2){
                
                
                System.out.println(ligne_texte);
                String ligne[]= ligne_texte.split(" ");
                for (int j = 0; j < ligne.length; j++) {
                    int q = Integer.parseInt(ligne[j])/16;
                    int r = Integer.parseInt(ligne[j])%16;
                    
                            
                            
                    try {
                        BufferedImage tileset = ImageIO.read(getClass().getResource("images/tileSetMinecraft32x32.png"));
                        BufferedImage uneTuile = tileset.getSubimage(r*32, q*32, tailleTuile, tailleTuile);
                        contexte.drawImage(uneTuile,  j*32,(i-3)*32, null);
                        } catch (IOException ex) {
                        Logger.getLogger(Carte.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    }
                }
                
                
                i++;
            }
            fichier.close();

        } catch (IOException e) {
            e.printStackTrace();
        }    
    }


}
