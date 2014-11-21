/**
 * Sprite.java
 * Adapted from the sprite class created by Jeff Ondich, the Sprite class provides methods to retrieve and set sprite properties in the game.
 * Chet Aldrich and Josie Bealle
 */

package sample;





import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;

public abstract class Sprite extends Group {
    // In addition to name and velocity, each Sprite also has a position
    // and size. Those attributes are a part of the Group superclass.
    private String name;
    private Point2D velocity;
    private Model model;

    public Sprite() {
    }

    public void setModel(Model model){
        this.model = model;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
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


    /**
     * Play a sound at collision.
     */
    abstract public void makeSound();
}

