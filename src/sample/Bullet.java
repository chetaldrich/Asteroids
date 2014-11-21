/**
 * Bullet.java
 * Bullet class -- the bullets that our spaceship fires at asteroids
 * Methods include getBounds, makeSound, etc.
 * Chet Aldrich and Josie Bealle
 */
package sample;


import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;



public class Bullet extends Sprite implements BulletInterface {

    private Point2D velocity;
    private Point2D position;
    private double radius;
    final private float id;
    /**
     * Constructor
     */
    public Bullet(){
        Random r = new Random();
        id = r.nextFloat();

        this.velocity = new Point2D(4, 0);
        Paint fill = Color.GRAY;
        this.radius = 2.0;
        Circle bullet = new Circle(0, 0, this.radius,  fill);
        this.getChildren().add(bullet);
    }
    public float getObjId(){
        return this.id;
    }

    /**
     * getPosition -- gets position of bullet
     * @return Point2D of position
     */
   public Point2D getPosition() {

       return this.position;
    }

    /**
     * setPosition -- sets position of bullet
     * @param x New x value
     * @param y New y value
     */
    public void setPosition(double x, double y) {
        this.position = new Point2D(x,y);
    }



    /**
     * getVelocity -- gets velocity of bullet
     * @return Point2D of velocity
     */
    public Point2D getVelocity() {

        return this.velocity;
    }
    
    /**
     * setVelocity -- gets velocity of bullet
     * @param x New x velocity
     * @param y New y velocity
     */
    public void setVelocity(double x, double y) {
        this.velocity = new Point2D(x,y);

    }

    /**
     * step -- sets new position according to velocity
     */
    public void step() {
        double xPos = this.position.getX();
        double yPos = this.position.getY();
        double xVel = this.velocity.getX();
        double yVel = this.velocity.getY();
        this.setPosition(xPos+xVel, yPos+yVel);
    }

    public void makeSound() {

    }
    public BoundingBox getBounds(){
        double xval= this.getPosition().getX();
        double yval = this.getPosition().getY();
        double xmin = xval - this.radius;
        double ymin = yval - this.radius;
        double widthAndHeight = 2*this.radius;
        return new BoundingBox(xmin, ymin, widthAndHeight, widthAndHeight);
    }
}
