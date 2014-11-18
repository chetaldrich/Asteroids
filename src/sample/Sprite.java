package sample;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;

/**
 * Created by josiebealle on 17/11/14.
 * Sprite class mainly written by Jeff Ondich
 */
public class Sprite extends Group{


    private Point2D velocity;


    public Sprite() {
    }



    public Point2D getPosition() {
        Point2D position = new Point2D(this.getLayoutX(), this.getLayoutY());
        return position;
    }

    public void setPosition(double x, double y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    public Point2D getVelocity() {
        return this.velocity;
    }

    public void setVelocity(double vx, double vy) {
        this.velocity = new Point2D(vx, vy);
    }

    public Point2D getSize() {
        Bounds bounds = this.getLayoutBounds();
        Point2D size = new Point2D(bounds.getWidth(), bounds.getHeight());
        return size;
    }

    public void setSize(double width, double height) {
        this.resize(width, height);
    }
    /**
     * Move the Sprite one step in the direction and magnitude
     * of its velocity.  Subclasses may override this method, which can
     * call super.step() and then perform any desired additional actions.
     */
    public void step() {
        Point2D position = this.getPosition();
        this.setPosition(position.getX() + this.velocity.getX(), position.getY() + this.velocity.getY());
    }

}
