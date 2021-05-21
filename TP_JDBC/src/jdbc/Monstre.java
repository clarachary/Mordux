/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author kthierry
 */
public class Monstre extends Personnage {
    int x;
    int y;
    String skin;
    String attack;
    
public Monstre() {
    this.x=0;
    this.y=0;
    this.skin="Default";
    this.attack="Default";
            

}  
public Monstre(int x, int y, String skin, String attack) {
    this.x=x;
    this.y=y;
    this.skin=skin;
    this.attack=attack;
            

}  
}
