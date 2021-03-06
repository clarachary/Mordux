package jdbc;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * Exemple de fenetre de jeu en utilisant l'éditeur d'interface de NetBeans
 *
 * @author guillaume.laurent
 */
public class FenetreDeJeuGUI extends javax.swing.JFrame implements ActionListener {

    private BufferedImage buffer;
    private Graphics2D contexteBuffer;
    private Jeu jeu;
    private Timer timer;
    private SQL Mordux= new SQL("20202021_s2_vs1_tp1_mordux");
    private javax.swing.JLabel jLabel1;
    /**
     * Creates new form NewJFrame
     */
    public FenetreDeJeuGUI() {
        initComponents();

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        int largeur =this.jLabel1.getWidth()+640;
        int hauteur =this.jLabel1.getHeight()+640;
        this.buffer = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_ARGB);
        jLabel1.setIcon(new ImageIcon(this.buffer));
        this.contexteBuffer = this.buffer.createGraphics();
        System.out.println("this.jLabel1.getWidth()= "+this.jLabel1.getWidth()+"; this.jLabel1.getHeight() ="+ this.jLabel1.getHeight());
        // Creation du jeu
        this.jeu = new Jeu(Mordux);

        // Creation du Timer qui appelle this.actionPerformed() tous les 40 ms
        this.timer = new Timer(1, this);
        this.timer.start();
    }

    // Methode appelee par le timer et qui contient la boucle de jeu
    public void actionPerformed(ActionEvent e) {
        

        this.jeu.miseAJour();
        try {
            this.jeu.rendu(contexteBuffer);
        } catch (IOException ex) {
            Logger.getLogger(FenetreDeJeuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jLabel1.repaint();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(20*32, 15*32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20*32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15*32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased                              
        
             if(evt.getKeyCode()==37){
                    Mordux.setx("Default", Mordux.getx("Default")-32);
                    Mordux.Affiche("joueur");}
                if(evt.getKeyCode()==38){
                    Mordux.sety("Default", Mordux.gety("Default")-32);
                    Mordux.Affiche("joueur");}
                if(evt.getKeyCode()==39){
                    Mordux.setx("Default", Mordux.getx("Default")+32);
                    Mordux.Affiche("joueur");}
                if(evt.getKeyCode()==40){
                    Mordux.sety("Default", Mordux.gety("Default")+32);
                    Mordux.Affiche("joueur");}
               
            

        
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            new FenetreDeJeuGUI().setVisible(true);
           
            
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    // End of variables declaration//GEN-END:variables


}
