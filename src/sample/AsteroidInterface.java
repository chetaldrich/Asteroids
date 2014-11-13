package sample;

import javafx.geometry.Point2D;

public interface AsteroidInterface {

    public Point2D getPosition();

    public void setPosition(double x, double y);

    public void setVelocity(double vx, double vy);

    public Point2D getVelocity();

    public void vanish();
}
