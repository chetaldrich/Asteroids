/**
 * ControllerInterface.java
 * Interface for the Controller class, which manipulates and creates game elements in the Asteroids game.
 * Chet Aldrich and Josie Bealle
 */

package sample;


public interface ControllerInterface {

   /**
    * Initializes game elements
    */
    public void initialize();

    public void handle();

    public void spriteRemove();

    public void cleanUpObjects();

    public void moveShipUp();

    public void moveShipDown();

    public void fireBullet();




}
