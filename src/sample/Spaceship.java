package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Spaceship class: Constructs a spaceship for our game. Methods include get/setPosition, get/setVelocity, vanish and step
 */
public class Spaceship extends Sprite implements SpaceshipInterface {

    private Point2D velocity;
    private Point2D position;
    /**
     * Constructor
     */
    public Spaceship() {
        this.velocity = new Point2D(0,0);
        this.position = new Point2D(100, 100);
        Image image = new Image(getClass().getResourceAsStream("/img/spaceship.png"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
    }

    /**
     * getPosition -- gets position of spaceship in the game.
     * @return Point2D current position
     */
    public Point2D getPosition() {
        return this.position;
    }

    /**
     * setPosition -- sets position of spaceship in the game.
     * @param x  desired x position
     * @param y  desired y position
     */
    public void setPosition(double x, double y) {
        this.position = new Point2D(x, y);
    }


    /**
     * getVelocity -- gets the current velocity of the spaceship.
     * @return Point2D current velocity
     */
    public Point2D getVelocity() {
        return this.velocity;
    }

    /**
     * setVelocity -- sets the velocity of the spaceship in the game.
     * @param x desired x velocity
     * @param y desired y velocity
     */
    public void setVelocity(double x, double y) {
        this.velocity = new Point2D(x, y);
    }

    /**
     * step -- Moves the spaceship to its next Point2D position in the game.
     */
    public void step() {
        Point2D position = this.getPosition();
        this.setPosition(position.getX() + this.velocity.getX(), position.getY() + this.velocity.getY());
    }

    public void makeSound(){
        //stub for the moment.
    }


}
