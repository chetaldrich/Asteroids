/**
 * BulletInterface.java
 * Bullet interface for the bullet class, which defines the bullets that our spaceship fires at asteroids
 * Methods include getBounds, makeSound, etc.
 * Chet Aldrich and Josie Bealle
 */

package sample;

import javafx.geometry.Point2D;


public interface BulletInterface {
    
    /**
     * getPosition -- gets position of bullet
     * @return Point2D of position
     */
    public Point2D getPosition();

    /**
     * setPosition -- sets position of bullet
     * @param x Desired x value of bullet
     * @param y Desired y value of bullet
     */
    public void setPosition(double x, double y);
    

    
    
    /**
     * getVelocity -- gets velocity of bullet
     * @return Point2D of velocity
     */
    public Point2D getVelocity();
    
    
    /**
     * setVelocity -- gets velocity of bullet
     * @param x New x velocity
     * @param y New y velocity
     */
    public void setVelocity(double x, double y);
    
    /**
     * step -- sets new position according to velocity
     */
    public void step();

}
