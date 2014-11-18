package sample;


import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


/** 
 * Bullet class -- the bullets that our spaceship fires at asteroids
 * Methods include get/setPosition, get/setVelocity, step, vanish
 */
public class Bullet extends Sprite implements BulletInterface {

    private Point2D velocity;
    private Point2D position;
    /**
     * Constructor
     * @param spaceshipPosition Point2D
     */
    public Bullet(Point2D spaceshipPosition){
        this.position = spaceshipPosition;
        this.velocity = new Point2D(4, 0);
        Paint fill = Color.GRAY;
        Circle bullet = new Circle(0, 0, 2.0,  fill);
        this.getChildren().add(bullet);
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
}
