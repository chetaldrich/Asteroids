package sample;

import javafx.geometry.Point2D;

/**
 * Asteroid class. Constructs an asteroid for our game. Methods include get/setPosition, get/setVelocity, and vanish
 */
public interface AsteroidInterface {

    /**
     * getPosition -- gets position of asteroid
     * @return Point2D of position
     */
    public Point2D getPosition();

    /**
     * setPosition -- sets position of asteroid
     * @param x  New x value
     * @param y  New y value
     */
    public void setPosition(double x, double y);

    public void setVelocity(double vx, double vy);

    public Point2D getVelocity();

    public void vanish();
}
