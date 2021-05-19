package jdbc;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Exemple de fenetre de jeu en utilisant uniquement des commandes
 *
 * @author guillaume.laurent
 */
public class FenetreDeJeu extends JFrame implements ActionListener {

    private BufferedImage buffer;
    private Graphics2D contexteBuffer;
    private Jeu jeu;
    private Timer timer;
    private JLabel jLabel1;

    public FenetreDeJeu() {
        // initialisation de la fenetre
        this.setSize(20*32, 15*32);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jLabel1 = new JLabel();
        this.jLabel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        this.setContentPane(this.jLabel1);
        this.pack();

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        this.buffer = new BufferedImage(this.jLabel1.getWidth(), this.jLabel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.jLabel1.setIcon(new ImageIcon(buffer));
        this.contexteBuffer = this.buffer.createGraphics();

        // Creation du jeu
        this.jeu = new Jeu();

        // Creation du Timer qui appelle this.actionPerformed() tous les 40 ms
        this.timer = new Timer(40, this);
        this.timer.start();
    }

    // Methode appelee par le timer et qui contient la boucle de jeu
    public void actionPerformed(ActionEvent e,Connection connexion) {
        this.jeu.miseAJour();
        try {
            this.jeu.rendu(contexteBuffer,connexion);
        } catch (IOException ex) {
            Logger.getLogger(FenetreDeJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jLabel1.repaint();
    }

        
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FenetreDeJeu fenetre = new FenetreDeJeu();
        fenetre.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
