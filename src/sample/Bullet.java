/**
 * Bullet.java
 * Bullet class -- holds data and constructs the bullets that our spaceship fires at asteroids
 * Methods include getBounds, makeSound, etc.
 * Chet Aldrich and Josie Bealle
 */
package sample;


import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;


public class Bullet extends Sprite implements BulletInterface {
    private Point2D velocity;
    private double radius;
    private Image image;
    private ImageView imageView;
    private AudioClip audioClip;

    /**
     * Constructor
     */
    public Bullet(){
        this.setName("bullet");
        this.velocity = new Point2D(12, 0);
        this.radius = 10.0;
        this.image = new Image(getClass().getResourceAsStream("/sample/img/laserbeam.png"), this.radius, this.radius, true, false);
        this.imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
        this.audioClip = new AudioClip(getClass().getResource("sounds/laser.mp3").toString());
    }

    /**
     * step -- sets new position according to velocity
     */
    public void step() {
        double xPos = this.getLayoutX();
        double yPos = this.getLayoutY();
        double xVel = this.velocity.getX();
        double yVel = this.velocity.getY();
        this.setPosition(xPos+xVel, yPos+yVel);
    }

    /**
     * makeSound -- make laser sound when bullets are fired from the ship.
     */
    public void makeSound() {
        this.audioClip.play();
    }


    /**
     * getBounds -- generates a bounding box for the bullet, which is then used to determine collisions.
     * @return boundingbox for the bullet object
     */
    public BoundingBox getBounds(){
        double xval= this.getPosition().getX();
        double yval = this.getPosition().getY();
        double xmin = xval - this.radius;
        double ymin = yval - this.radius;
        double widthAndHeight = 2*this.radius;
        return new BoundingBox(xmin, ymin, widthAndHeight, widthAndHeight);
    }
}
