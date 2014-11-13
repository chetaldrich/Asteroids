package sample;


import javafx.geometry.Point2D;

/**
 * Created by chetaldrich on 11/12/14.
 */

public class Bullet implements BulletInterface {
    public Point2D getPosition() {

        return new Point2D(0,0);
    }

    public Point2D setPosition(double x, double y) {

        return new Point2D(x,y);
    }

    public void vanish() {
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
}