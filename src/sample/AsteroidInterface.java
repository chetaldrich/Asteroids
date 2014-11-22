/**
 * AsteroidInterface.java
 * Asteroid interface for our asteroid class, which constructs an asteroid for our game. Methods include get/set Radius, makeSound, etc.
 * Chet Aldrich and Josie Bealle
 */
package sample;

import javafx.geometry.Point2D;


public interface AsteroidInterface {

    /**
     * step -- sets new position according to velocity
     */
    public void step();

    /**
     * getRadius -- returns radius of asteroid
     * @return double of radius
     */
    public double getRadius();

    /**
     * setRadius -- sets radius of asteroid, calls setSize
     * @param newRadius of  new radius
     */
    public void setRadius(double newRadius);

    /**
     * setSize --redraws image, called by setRadius
     * @param width  new width
     * @param height new height
     */
    public void setSize(double width, double height);

    public void makeSound();

}
