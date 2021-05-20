/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.awt.image.BufferedImage;

/**
 *
 * @author Ghani
 */
public class Goblin extends Monstre{
    private BufferedImage sprite;
}

public Goblin(int xpos, int ypos, int P_attack, int Pv, int Speed, int Vision) {
        super.(xpos, ypos, P_attack, Pv, Speed, Vision)
        try {
            this.sprite = ImageIO.read(getClass().getResource("../resources/goblin.png"));
        } catch (IOException ex) {
            Logger.getLogger(Goblin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }