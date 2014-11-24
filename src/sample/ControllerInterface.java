/**
 * ControllerInterface.java
 * Interface for the Controller class, which manipulates and creates game elements in the Asteroids game.
 * Chet Aldrich and Josie Bealle
 */

package sample;


import javafx.stage.Stage;

import java.io.IOException;

public interface ControllerInterface {

   /**
    * initialize -- initializes game the beginning game elements and starts the animation timer.
    */
    public void initialize();

    /**
     * setPreviousStage -- sets the previous stage of the program for closing in subsequent windows.
     * @param stage stage that was previously focused
     */
    public static void setPreviousStage(Stage stage){}

    /**
     * setCurrentStage -- sets the current focused stage of the game for later closing.
     * @param stage the current focused stage
     */
    public static void setCurrentStage(Stage stage){}


    /**
     * gotoMenu -- goes to the game home menu when certain triggers occur (death, possibly other functions)
     * @throws java.io.IOException
     */
    public void gotoMenu() throws IOException;

    /**
     * makeAsteroids -- generates Asteroids in the model and inserts them into the view for use in game.
     */
    public void makeAsteroids();

    /**
     * toggleMusic -- toggles play of music.
     */
    public void toggleMusic();

    /**
     * checkGameCollisions -- checks the game for collisions between objects, and then calls the associated methods required for cleanup.
     */
    public void checkGameCollisions();

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
