

package sample;


import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;

/**
 * Sprite.java
 * Adapted from the sprite class created by Jeff Ondich, the Sprite class provides methods to retrieve and set sprite properties in the game.
 * Chet Aldrich and Josie Bealle
 */
public abstract class Sprite extends Group {
    // In addition to name and velocity, each Sprite also has a position
    // and size. Those attributes are a part of the Group superclass.
    private String name;
    private Point2D velocity;
    private Model model;

    public Sprite() {
    }

    /**
     * setModel -- sets the model of the sprite
     * @param model
     */
    public void setModel(Model model){
        this.model = model;
    }

    /**
     * getName -- gets the name of the sprite
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * setName -- sets name of sprite
     * @param newName
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * getPosition -- gets position of sprite
     * @return Point2D position
     */
    public Point2D getPosition() {
        Point2D position = new Point2D(this.getLayoutX(), this.getLayoutY());
        return position;
    }

    /**
     * setPosition -- sets position of sprite
     * @param x new x
     * @param y new y
     */
    public void setPosition(double x, double y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    /**
     * getBounds -- gets the outer bounds of this object
     * @return BoundingBox of this particular object (each corner of the box surrounding a game object
     */
    public BoundingBox getBounds(){
        Point2D center = this.getPosition();
        Point2D size = this.getSize();
        double minX = center.getX()-0.5*size.getX();
        double minY = center.getY()-0.5*size.getY();
        return new BoundingBox(minX, minY, size.getX(), size.getY());
    }

    /**
     * getVelocity() -- gets velocity of sprite
     * @return Point2D of velocity
     */
    public Point2D getVelocity() {
        return this.velocity;
    }

    /**
     * setVelocity -- sets velocity of sprite
     * @param vx
     * @param vy
     */
    public void setVelocity(double vx, double vy) {
        this.velocity = new Point2D(vx, vy);
    }

    /**
     * getSize-- gets size of sprite
     * @return Point2D size
     */
    public Point2D getSize() {
        Bounds bounds = this.getLayoutBounds();
        Point2D size = new Point2D(bounds.getWidth(), bounds.getHeight());
        return size;
    }

    /**
     * setSize -- sets size of sprite
     * @param width
     * @param height
     */
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

