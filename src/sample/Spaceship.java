package sample;

import javafx.geometry.Point2D;

/**
 * Spaceship class. Constructs a spaceship for our game. Methods include get/setPosition, get/setVelocity, step, and getLives
 */
public class Spaceship implements SpaceshipInterface {
    /**
     * Constructor
     */
    public Spaceship() {
    }

    /**
     * getPosition -- gets position of spaceship
     * @return Point2D of position
     */
    public Point2D getPosition() {
        return new Point2D(0,0);
    }

    /**
     * setPosition -- sets position of spaceship
     * @param x  New x value
     * @param y  New y value
     * @return  void
     */
    public Point2D setPosition(double x, double y) {
        return new Point2D(x,y);
    }

    /**
     *
     */
    public void explode() {
        //stub :)
    }

    public Point2D getVelocity() {

        return new Point2D(0,0);
    }
    public void setVelocity(double x, double y) {

    }

    public void step(String direction) {
        //stub :)
    }

    public int getLives() {
        return 0;
    }
}
