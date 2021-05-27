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

    private int tailleTuile = 32;
    private BufferedImage[] ListeTuile;
    private Integer[][] Map;

    public Carte() {
        this.Map= new Integer[1][1];
        this.ListeTuile= new BufferedImage[166];
    }
    
    public Carte(String nomFichier) {
        this.ListeTuile= new BufferedImage[176];

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier + ".txt"));

            while (fichier.ready()) {
                String ligne_info;
                String ligne_texte;
                fichier.readLine();
                fichier.readLine();
                ligne_info= fichier.readLine();
                String nc_string[] = ligne_info.split(" ");
                int nc = Integer.parseInt(nc_string[0]);
                int nl = Integer.parseInt(nc_string[1]);
                this.Map=new Integer[nl][nc];
                
                for(int y=0; y<nl;y++){
                    ligne_texte = fichier.readLine();
                    String ligne[]= ligne_texte.split(" ");

                    for (int x = 0; x <nc; x++) {
                        Map[y][x]=Integer.parseInt(ligne[x]);
                        System.out.println("ligne["+y+"] =" + ligne[x]+" Map["+x+"]["+y+"]="+Map[y][x]);
                        System.out.println(Map[y][x]);
                    }
                }
                
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
        
        
        
        
    
      System.out.println("Map[2].length =" + Map[2].length);
      System.out.println("Map.length =" + Map.length);
      System.out.println("ListeTuile =" +ListeTuile);
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
    
    
   /* public void rendu(Graphics2D contexte, String nomFichier) throws FileNotFoundException {
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
    }*/


}
