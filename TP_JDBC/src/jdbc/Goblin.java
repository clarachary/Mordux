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

public class Goblin extends Monstre {
private final int Pv;
	
	private final int P_attack;
	private final int Speed;
	private final int xpos, ypos;
	private final boolean Vision; 
	public Goblin(String name, Sprite sprite, int xpos, int ypos, int Pv, int P_attack) {
		super(name, sprite, xpos, ypos);
		this.Pv = Pv;
		this.P_attack = P_attack;
		this.xpos = xpos;
		this.ypos = ypos;
                this.Sprite = Sprite;
	}

	//@Override
	//public void update(){
		//super.update();
	//}
	
	/*
	 * Get monsters attack and players defense
	 * Calculate damage, ensuring that it is always at least 1 no matter
	 * how high the player's defense and pass this to the player class
	 */
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
		Pv -= damage;
		if(hp < 0){
			Pv = 0;
		}
	}
	
	//Call potion object and add it's value to current hp. If current hp then
	//exceeds max hp, it will be set to max hp
	public void heal(Potion potion){
		hp += potion.getHpBoost();
		if(hp > max_hp){
			hp = max_hp;
		}
	}

	// getters and setters
	
        public boolean getVision(){
                return Vision;
        }
	public int getAttack() {
		return P_attack;
	}

	public int getPv() {
		return Pv;
	}

	public void setHp(int hp) {
		this.Pv = Pv;
	}

	
	public int xpos() {
		return xpos;
	}
	
	public int ypos() {
		return ypos;
	}
}