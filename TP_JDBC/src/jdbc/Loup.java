/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

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
   

