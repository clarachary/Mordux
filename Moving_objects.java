
import java.util.Vector;


/**
 *
 * @author kthierry
 */
public class Moving_objects {
    //Atributs de Moving_objects
    private int xpos; 
    private int ypos;
    private double velocity;
    private String skin;
    private String pseudo;
    private int pv;

    public Moving_objects(int xpos, int ypos, double velocity, String skin, String pseudo, int pv) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.velocity = velocity;
        this.skin = skin;
        this.pseudo = pseudo;
        this.pv = pv;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public double getVelocity() {
        return velocity;
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
       
}

    
