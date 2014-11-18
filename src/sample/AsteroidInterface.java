package sample;

import javafx.geometry.Point2D;

/**
 * Asteroid class. Constructs an asteroid for our game. Methods include get/setPosition, get/setVelocity, and vanish
 */
public interface AsteroidInterface {

    /*/**
     * getPosition -- gets position of asteroid
     * @return Point2D of position
     */
    /*public Point2D getPosition();

    /**
     * setPosition -- sets position of asteroid
     * @param x  New x value
     * @param y  New y value
     */
    /*public void setPosition(double x, double y);

    /**
     * setVelocity --sets velocity of asteroid
     * @param x New x velocity
     * @param y New y velocity
     */
    //public void setVelocity(double vx, double vy);

    /*/**
     * getVelocity -- gets velocity of asteroid
     * @return Point2D of velocity
     */
    //public Point2D getVelocity();

    /*/**
     * vanish -- makes the asteroid disappear from screen
     * (so like when it smashes into  the spaceship)
     */
    /*public void vanish();*/

    /*/**
     * step -- sets new position according to velocity
     */
    //public void step();

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
