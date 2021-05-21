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
    
    private BufferedImage[] ListeTuile;
    private Integer[][] Map;

    public Carte() {
        this.Map= new Integer[20][20];
        this.ListeTuile= new BufferedImage[166];
    }
    
    public Carte(String nomFichier) {
        int i = 0;
        int a=0;
        Integer[][] Plan= new Integer[10000][10000];
        this.ListeTuile= new BufferedImage[176];
        
        
        
        try {
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier + ".txt"));

            while (fichier.ready()) {
                String ligne_texte;
                ligne_texte = fichier.readLine();
                if(i>2){
                
                
                
                String ligne[]= ligne_texte.split(" ");
                a=ligne.length;
                for (int j = 0; j <a; j++) {
                    Plan[i-3][j]=Integer.parseInt(ligne[j]);
                    System.out.println(Plan[i-3][j]);
                    }
                }
                i++;
            }
            fichier.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        for (int l = 0; l <11; l++) {
            for (int c = 0; c < 16; c++) {
                try {
                        BufferedImage tileset = ImageIO.read(getClass().getResource("images/tileSetMinecraft32x32.png"));
                        BufferedImage uneTuile = tileset.getSubimage(c*32, l*32, tailleTuile, tailleTuile);
                        System.out.println(l);
                        System.out.println(c);
                        ListeTuile[l*16+c]=uneTuile;
                        
                        } catch (IOException ex) {
                        Logger.getLogger(Carte.class.getName()).log(Level.SEVERE, null, ex);
                         }
            }
        }
        
        
        
        this.Map=new Integer[i-3][a];
        for (int l = 0; l < i-3; l++) {
            for (int c = 0; c < a; c++) {
                Map[l][c]=Plan[l][c];
            }            
        }
    
      System.out.println(Map[2].length);
      System.out.println(ListeTuile);
    }
    
    

    public void miseAJour() {

    }
    public void rendu(Graphics2D contexte) {
        for (int l = 0; l < Map.length; l++) {
            for (int c = 0; c < Map[2].length; c++) {
                BufferedImage uneTuile=ListeTuile[Map[l][c]];
                contexte.drawImage(uneTuile,  c*32,l*32, null);
            }            
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
