/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**

 * @author kthierry
 */
public class Loup extends Monstre {
    
   Protected BufferedImage sprite;
    protected double x, y;
    public Loup() {
        try {
            this.sprite = ImageIO.read(getClass().getResource("F:\\info\\Sprites\Loup_crop.png"));
        } catch (IOException ex) {
            Logger.getLogger(Loup.class.getName()).log(Level.SEVERE , null, ex);
        }     
    this.attack="Croque";
    this.skin="Loup";
    this.x=0;
    this.y=0;
}
}
   



public class Loup extends Monstre {
    
    private final int Pv;
    private final int attack;
    private final int Speed;
    private final int xpos, ypos;	
    private final String skin;
    public Loup(String name, String sprite, int xpos, int ypos, int Pv, int attack) {
		super(name, skin, xpos, ypos);
		this.Pv = Pv;
		this.attack = attack;
		this.xpos = xpos;
		this.ypos = ypos;
                this.skin = skin;
                this.Speed = Speed;
        }

	//@Override
	//public void update(){
		//super.update();
	//}
	
	
    public void attack(Player player){
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
		Pv = Pv - damage;
		if(Pv < 0){
			Pv = 0;
		}
	}
	
	//Call potion object and add it's value to current hp. If current hp then
	//exceeds max hp, it will be set to max hp
	public void heal(Potion potion){
		Pv += potion.getHpBoost();
				}
	

	// getters and setters
	
        
	public int getAttack() {
		return attack;
	}

	public int getPv() {
		return Pv;
	}

	public void setHp(int Pv) {
		this.Pv = Pv;
	}

	
	public int xpos() {
		return xpos;
	}
	
	public int ypos() {
		return ypos;
	}
         public void rendu(Graphics2D contexte) {
             BufferedImage tileset = ImageIO.read(getClass().getResource("images/tileSetMinecraft32x32.png"));
      
                contexte.drawImage(uneTuile,  xpos, ypos, null);
                
        }
        
    } 
