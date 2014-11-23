/**
 * Spaceship.java
 * Spaceship class: Constructs a spaceship for our game. Methods include get/setPosition, get/setVelocity, and step
 * Chet Aldrich and Josie Bealle
 */

package sample;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;


public class Spaceship extends Sprite implements SpaceshipInterface {

    private Point2D velocity;
    //private Point2D position;
    private Image image;
    private ImageView imageView;
    private AudioClip audioClip;

    /**
     * Constructor
     */
    public Spaceship() {
        this.setName("spaceship");
        this.velocity = new Point2D(0,0);
        //this.position = new Point2D(100, 100);
        this.setPosition(200, 400);
        image = new Image(getClass().getResourceAsStream("/sample/img/spaceship.png"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
        this.audioClip = new AudioClip(getClass().getResource("/res/explosion.mp3").toString());
    }

    @Override
    public void setSize(double width, double height) {
        super.setSize(width, height);
        this.getChildren().remove(imageView);
        image = new Image(getClass().getResourceAsStream("/sample/img/spaceship.png"), width, height, true,false);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
    }

    /**
     * step -- Moves the spaceship to its next Point2D position in the game.
     */
    @Override
    public void step() {
        Point2D position = this.getPosition();
        this.setPosition(position.getX() + this.velocity.getX(), position.getY() + this.velocity.getY());
    }

    //is this ever called?????
    public String getSpriteType(){
        return "spaceship";
    }

    @Override
    public void makeSound(){
        this.audioClip.play();
    }


}
