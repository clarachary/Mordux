/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guillaume.laurent
 */
public class TestSelect {

    public static void main(String[] args) {

        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/20202021_s2_vs1_tp1_mordux?serverTimezone=UTC", "frodon", "XtCQDfMaoqzTyVam");

            PreparedStatement requete = connexion.prepareStatement("SELECT x   FROM joueur WHERE pseudo=?;");
            requete.setString(1, "frodon");
            ResultSet resultat = requete.executeQuery();
            
            while (resultat.next()) {
                int x = resultat.getInt("x");
                System.out.println(x);
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
