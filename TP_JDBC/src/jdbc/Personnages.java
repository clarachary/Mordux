/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.util.Vector;

/**
 *
 * @author kthierry
 */
public class Personnages {
    private int xpos; 
    private int ypos;
    private String skin;
    private String pseudo;
    private int pv;

    public Personnages(int xpos, int ypos, double velocity, String skin, String pseudo, int pv) {
        this.xpos = 0;
        this.ypos = 0;
        this.skin = "skin";
        this.pseudo = "pseudo";
        this.pv = 10;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }


    public String getSkin() {
        return skin;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getPv() {
        return pv;
    }
    
    public Vector getPosition (){
        Vector pos = new Vector(this.getXpos(),this.getYpos());
        return pos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
       
}
    

