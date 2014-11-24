/**
 * ControllerInterface.java
 * Interface for the Controller class, which manipulates and creates game elements in the Asteroids game.
 * Chet Aldrich and Josie Bealle
 */

package sample;


public interface ControllerInterface {

   /**
    * initialize -- initializes game the beginning game elements and starts the animation timer.
    */
    public void initialize();

    /**
     * handle -- implements keystroke handling, including spaceship movement and bullet firing.
     */
    public void handle();

    /**
     * fireBullet -- fires a bullet from the spaceship by creating a new Bullet instance at that location.
     */
    public void fireBullet();


    /**
     * cleanUpObjects -- removes objects that have collided with each other, and instantiates new ones if necessary.
     */
    public void cleanUpObjects();







}
