package sample;

import javafx.geometry.Point2D;

public interface BulletInterface {
    public Point2D getPosition();
    public Point2D setPosition(double x, double y);
    public void vanish();
    public Point2D getVelocity();
    public void setVelocity(double x, double y);
    public void step(String direction);

}