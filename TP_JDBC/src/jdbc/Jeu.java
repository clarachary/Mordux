package jdbc;

import jdbc.Carte;
import java.awt.Graphics2D;
import java.io.IOException;
import java.sql.Connection;

/**
 * Exemple de classe jeu
 *
 * @author guillaume.laurent
 */
public class Jeu {

    private Carte carte;
    SQL Base_Donnee;
    private Personnage Joueur1;
    
     
    public Jeu(SQL Base_Donnee) {        
        this.carte = new Carte();
        this.Base_Donnee=Base_Donnee;
        this.Joueur1=new Personnage(Base_Donnee);
    }

    public void miseAJour() {
        this.Joueur1.miseAJour();
    }

    public void rendu(Graphics2D contexte) throws IOException {
        this.carte.rendu(contexte,"Carte3");
        this.Joueur1.rendu(contexte);
    }

}
