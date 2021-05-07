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
    private Joueur Joueur1=new Joueur();
    
     
    public Jeu() {        
        this.carte = new Carte();
    }

    public void miseAJour() {
        this.Joueur1.miseAJour();
    }

    public void rendu(Graphics2D contexte, Connection connexion) throws IOException {
        this.carte.rendu(contexte,"Carte");
        this.Joueur1.rendu(contexte,connexion);
    }

}
