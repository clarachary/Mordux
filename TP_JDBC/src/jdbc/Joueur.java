/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author truil
 */
public class Joueur extends Personnages {
    private String Pseudo;
    private SQL Base_Donnee;
    
public Joueur(String Pseudo, SQL Base_Donnee ){
    this.Pseudo=Pseudo;
    this.Base_Donnee=Base_Donnee;
    this.Base_Donnee.AjouterJoueur(Pseudo);
}

public Joueur(SQL Base_Donnee){
    
    this.setXpos(this.Base_Donnee.getx(this.Pseudo));
    this.Base_Donnee=Base_Donnee;
    this.Pseudo= this.Base_Donnee.getPseudo(0);
    if(Pseudo==""){
    this.Base_Donnee.AjouterJoueur("Default");
    }
}

public String getPseudo(){
    return this.Pseudo;
}
public SQL getBase_Donnee(){
    return this.Base_Donnee;
}


public int getY(Connection connexion){
    return this.Base_Donnee.gety(this.Pseudo);

}
public String getSkin(){
    return this.Base_Donnee.getSkin(this.Pseudo);

}
public void setX(int X,Connection connexion){
    this.Base_Donnee.setx(this.Pseudo,X);
    
}
public void setY(int Y,Connection connexion){
    this.Base_Donnee.sety(this.Pseudo,Y);
    
}
public void miseAJour() {

    }
public void rendu(Graphics2D contexte,Connection connexion) {
        try {
            BufferedImage Skin = ImageIO.read(getClass().getResource("images/"+this.Base_Donnee.getSkin(Pseudo)+".png"));
            contexte.drawImage(Skin, this.getXpos( ), this.getY(connexion), null);
        } catch (IOException ex) {
            Logger.getLogger(Carte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

