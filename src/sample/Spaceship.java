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
     * getPosition -- gets position of spaceship in the game.
     * @return Point2D current position
     */
    public Point2D getPosition() {
        return new Point2D(0,0);
    }

    /**
     * setPosition -- sets position of spaceship in the game.
     * @param x  desired x position
     * @param y  desired y position
     * @return  void
     */
    public Point2D setPosition(double x, double y) {
        return new Point2D(x,y);
    }

    /**
     * explode -- destroys the spaceship if too damaged, adds a new one if available, then deducts one life.
     * @return void
     */
    public void explode() {
        //stub :)
    }

    /**
     * getVelocity -- gets the current velocity of the spaceship.
     * @return Point2D current velocity
     */
    public Point2D getVelocity() {
        return new Point2D(0,0);
    }

    /**
     * setVelocity -- sets the velocity of the spaceship in the game.
     * @param x desired x velocity
     * @param y desired y position
     * @return Point2D type position
     */
    public void setVelocity(double x, double y) {

    }

    /**
     * step -- Moves the spaceship to its next Point2D position in the game.
     * @return void
     */
    public void step() {
        //stub :)
    }


}
