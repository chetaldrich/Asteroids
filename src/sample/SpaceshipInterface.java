package sample;
import javafx.geometry.Point2D;


public interface SpaceshipInterface {

    public Point2D getPosition();
    public Point2D setPosition(double x, double y);
    public void explode();
    public Point2D getVelocity();
    public void setVelocity(double x, double y);
    public void step();

}
