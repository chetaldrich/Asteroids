package sample;

import javafx.geometry.Point2D;

/**
 * Spaceship class: Constructs a spaceship for our game. Methods include get/setPosition, get/setVelocity, vanish and step
 */
public class Spaceship implements SpaceshipInterface {

    private Point2D velocity;
    private Point2D position;
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
     */
    public void setPosition(double x, double y) {

    }

    /**
     * vanish -- destroys the spaceship if too damaged, adds a new one if available, then deducts one life.
     */
    public void vanish() {
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
     * @param y desired y velocity
     */
    public void setVelocity(double x, double y) {

    }

    /**
     * step -- Moves the spaceship to its next Point2D position in the game.
     */
    public void step() {
        //stub :)
    }


}
