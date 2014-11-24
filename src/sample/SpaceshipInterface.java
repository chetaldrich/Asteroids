/**
 * SpaceshipInterface.java
 * SpaceshipInterface: Interface for the Spaceship class, which constructs a spaceship for our game.
 * Chet Aldrich and Josie Bealle
 */

package sample;
import javafx.geometry.Point2D;


public interface SpaceshipInterface {

    /**
     * setSize --redraws image
     * @param width new width
     * @param height new height
     */
    public void setSize(double width, double height);


    /**
     * makes sound when spaceship explodes
     */
    public void makeSound();



}
