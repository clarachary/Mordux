/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author gsemroud
 */
public class Monstre {
    private int xpos;
    private int ypos;
    private int P_attack;
    private int Pv;
    private int Speed;
    private int Vision; 
}

public Monstre(int xpos, int ypos, int P_attack, int Pv, int Speed, int Vision) {
        this.xpos=xpos;
        this.ypos=ypos;
        this.P_attack = P_attack;
        this.Pv = Pv;
        this.Speed = Speed;
        this.Vision=Vision;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public void miseAJour() {
        while ((Joueur.xpos-this.xpos)^2+(Joueur.ypos-this.ypos)^2 <= this.Vision) {
            this.xpos= ;
        }
    }
