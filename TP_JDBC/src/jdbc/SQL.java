/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import outils.OutilsJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guillaume.laurent
 */
public class SQL {

    String Nomdelabasededonnées;
    
    public SQL(String Nom){
        this.Nomdelabasededonnées=Nom;}
    
    
    public int getx(String NomJoueur,Connection connexion){
        int abscisse;
        abscisse=0;
        try {

            
            PreparedStatement requete = connexion.prepareStatement("SELECT x  FROM joueur WHERE pseudo = ? ;");
            requete.setString(1, NomJoueur);
            ResultSet resultat = requete.executeQuery();
            
            while (resultat.next()) {
            abscisse   = resultat.getInt("x");
                
            }

            requete.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return abscisse;}
    public String getSkin(String NomJoueur){
        String Skin;
        Skin="";
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/"+this.Nomdelabasededonnées+"?serverTimezone=UTC", "frodon", "XtCQDfMaoqzTyVam");

            PreparedStatement requete = connexion.prepareStatement("SELECT skin  FROM joueur WHERE pseudo = ? ;");
            requete.setString(1, NomJoueur);
            ResultSet resultat = requete.executeQuery();
            
            while (resultat.next()) {
            Skin   = resultat.getString("skin");
                
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Skin;}
     public String getPseudo(int n){
        String Pseudo;
        Pseudo="";
        int i=0;
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/"+this.Nomdelabasededonnées+"?serverTimezone=UTC", "frodon", "XtCQDfMaoqzTyVam");

            PreparedStatement requete = connexion.prepareStatement("SELECT pseudo  FROM joueur");
            ResultSet resultat = requete.executeQuery();
            
            while (resultat.next()) {
                if(i==n){
            Pseudo   = resultat.getString("pseudo");
                }
                i++;
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Pseudo;}
    public void setx(String NomJoueur, int abcsisse,Connection connexion){
    
        try {

           

            PreparedStatement requete = connexion.prepareStatement("UPDATE joueur SET x = ? WHERE pseudo = ?");
            requete.setInt(1, abcsisse);
            requete.setString(2, NomJoueur);
            requete.executeUpdate();

            requete.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    
    
    public int gety(String NomJoueur,Connection connexion){
        int ordonnee;
        ordonnee=0;
        try {

           

            PreparedStatement requete = connexion.prepareStatement("SELECT y  FROM joueur WHERE pseudo = ? ;");
            requete.setString(1, NomJoueur);
            ResultSet resultat = requete.executeQuery();
            
            while (resultat.next()) {
            ordonnee   = resultat.getInt("y");
                
            }

            requete.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordonnee;}
    
    public void sety (String NomJoueur, int ordonnee,Connection connexion){
    
        try {

            

            PreparedStatement requete = connexion.prepareStatement("UPDATE joueur SET y = ? WHERE pseudo = ?");
            requete.setInt(1, ordonnee);
            requete.setString(2, NomJoueur);
            requete.executeUpdate();

            requete.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }

    public void Affiche(String NameTable){
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/"+this.Nomdelabasededonnées+"?serverTimezone=UTC", "frodon", "XtCQDfMaoqzTyVam");

            PreparedStatement requete = connexion.prepareStatement("SELECT * FROM "+NameTable+";");
            
            ResultSet resultat = requete.executeQuery();
            OutilsJDBC.afficherResultSet(resultat);

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void EffacerJoueur(String NomduJoueur){
        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/"+this.Nomdelabasededonnées+"?serverTimezone=UTC", "frodon", "XtCQDfMaoqzTyVam");

            PreparedStatement requete = connexion.prepareStatement("DELETE FROM joueur WHERE pseudo = ?");
            requete.setString(1, NomduJoueur);
            requete.executeUpdate();

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void AjouterJoueur(String NomJoueur){
        try {
            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/"+this.Nomdelabasededonnées+"?serverTimezone=UTC", "frodon", "XtCQDfMaoqzTyVam");
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO joueur VALUES (?,?,?,?,?)");
            requete.setString(1, NomJoueur);
            requete.setInt(2, 0);
            requete.setInt(3, 0);
            requete.setDouble(4, 1000);
            requete.setString(5, "Default");   
            System.out.println(requete);
            requete.executeUpdate();

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
       SQL Mordux= new SQL("20202021_s2_vs1_tp1_mordux");
       Mordux.Affiche("Joueur");
       Joueur Joueur1= new Joueur();
       System.out.println(Mordux.getPseudo(9));
       Mordux.Affiche("Joueur");
       Mordux.EffacerJoueur("Default");
       
       

    }

}
