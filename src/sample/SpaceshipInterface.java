package sample;
import javafx.geometry.Point2D;

/**
 * SpaceshipInterface: Interface for the Spaceship class, which constructs a spaceship for our game.
 */
public interface SpaceshipInterface {

    /**
     * getPosition -- gets position of spaceship in the game.
     * @return Point2D current position
     */
    public Point2D getPosition();

    /**
     * setPosition -- sets position of spaceship in the game.
     * @param x  desired x position
     * @param y  desired y position
     * @return  void
     */
    public Point2D setPosition(double x, double y);

    /**
     * explode -- destroys the spaceship if too damaged, adds a new one if available, then deducts one life.
     * @return void
     */
    public void explode();

    /**
     * getVelocity -- gets the current velocity of the spaceship.
     * @return Point2D current velocity
     */
    public Point2D getVelocity();

    /**
     * setVelocity -- sets the velocity of the spaceship in the game.
     * @param x desired x velocity
     * @param y desired y position
     * @return Point2D type position
     */
    public void setVelocity(double x, double y);

    /**
     * step -- Moves the spaceship to its next Point2D position in the game.
     * @return void
     */
    public void step();

}
