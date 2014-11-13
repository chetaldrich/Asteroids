package sample;

import javafx.geometry.Point2D;
import javafx.scene.Group;


public class Asteroid implements AsteroidInterface{

    private Point2D velocity;
    private Point2D position;


    public Asteroid(){

    }

    public Point2D getPosition() {
        return new Point2D(0,0);
    }

    public void setPosition(double x, double y){
        // stub. :)
    }

    public void vanish() {
        return;
    }

    public Point2D getVelocity(){
        return this.velocity;
    }

    public void setVelocity(double vx, double vy) {
        this.velocity = new Point2D(vx, vy);
    }


}