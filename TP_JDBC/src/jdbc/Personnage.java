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
import java.io.File;

/**
 *
 * @author truil
 */
public class Personnage {
    private String Pseudo;
    private SQL Base_Donnee;
    
public Personnage(String Pseudo, SQL Base_Donnee ){
    this.Pseudo=Pseudo;
    this.Base_Donnee=Base_Donnee;
    this.Base_Donnee.AjouterJoueur(Pseudo);
}

public Personnage(SQL Base_Donnee){
 
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

public int getX(){
    return this.Base_Donnee.getx(this.Pseudo);

}

public int getY(){
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
public void rendu(Graphics2D contexte) {
        try {
            BufferedImage Skin = ImageIO.read(new File ("Z:/Mes documents/GitHub/Mordux/TP_JDBC/src/jdbc/images/"+this.Base_Donnee.getSkin(Pseudo)+".png"));
            contexte.drawImage(Skin, this.getX( ), this.getY(), null);
        } catch (IOException ex) {
            Logger.getLogger(Carte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

