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



public class Goblin extends Monstre {
    
    private final int Pv;
    private final int attack;
    private final int Speed;	
    private final String skin;
    
	public Goblin(String sprite, int xpos, int ypos, int attack) {
		super(name);
		this.Pv = 200;
		this.attack = attack;
                this.skin = skin;
                this.Speed = 0;
        }

	//@Override
	//public void update(){
		//super.update();
	//}
	
	
    public void attack(Personnage player){
		int result = attack;
		if(result <= 0){
			result = 1;
		}
		player.takeDamage(result);
	}
	
	/*
	 * Represents a monster taking damage, where
	 * hp is reduced. If hp goes below 0 then it is
	 * reset to zero
	 */
	public void takeDamage(int damage){
		int pv_temp = Pv;
                pv_temp = Pv - damage;
		if(Pv < 0){
			pv_temp = 0;
		}
	}
	
	//Call potion object and add it's value to current hp. If current hp then
	//exceeds max hp, it will be set to max hp
	

	// getters and setters
	
        
	public int getAttack() {
		return attack;
	}

	public int getPv() {
		return Pv;
	}

	 
	

	
	public int xpos() {
		return xpos;
	}
	
	public int ypos() {
		return ypos;
	}
         public void rendu(Graphics2D contexte) {
        try {
            BufferedImage tileset = ImageIO.read(new File ("Z:/Mes documents/GitHub/Mordux/TP_JDBC/src/TileMapping/images"));
            contexte.drawImage(tileset,  xpos, ypos, null);
        } catch (IOException ex) {
            Logger.getLogger(Goblin.class.getName()).log(Level.SEVERE, null, ex);
        }

                
        }
        
    } 

