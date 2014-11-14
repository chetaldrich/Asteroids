package sample;


import javafx.geometry.Point2D;


/** 
 * Bullet class -- the bullets that our spaceship fires at asteroids
 * Methods include get/setPosition, get/setVelocity, step, vanish
 */
public class Bullet implements BulletInterface {

    private Point2D velocity;
    private Point2D position;
    /**
     * Constructor
     */
    public Bullet(){

    }


    /**
     * getPosition -- gets position of bullet
     * @return Point2D of position
     */
   public Point2D getPosition() {

        return new Point2D(0,0);
    }

    /**
     * setPosition -- sets position of bullet
     * @param x New x value
     * @param y New y value
     */
    public void setPosition(double x, double y) {

    }

    /**
     * vanish -- makes bullet disappear from screen, like when it hits an asteroid
     */
    public void vanish() {
        //stub :)
    }

    /**
     * getVelocity -- gets velocity of bullet
     * @return Point2D of velocity
     */
    public Point2D getVelocity() {

        return new Point2D(0,0);
    }
    
    /**
     * setVelocity -- gets velocity of bullet
     * @param x New x velocity
     * @param y New y velocity
     */
    public void setVelocity(double x, double y) {

    }

    /**
     * step -- sets new position according to velocity
     */
    public void step() {
        //stub :)
    }
}
