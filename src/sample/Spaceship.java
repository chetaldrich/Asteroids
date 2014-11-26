

package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

/**
 * Spaceship.java
 * Spaceship class: Constructs a spaceship for our game. Methods include get/setPosition, get/setVelocity, and step
 * Chet Aldrich and Josie Bealle
 */
public class Spaceship extends Sprite {

    private Point2D velocity;
    private Image image;
    private ImageView imageView;
    private AudioClip audioClip;
    private boolean isSpaceshipImage;
    private Point2D oldPosition;

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
        this.audioClip = new AudioClip(getClass().getResource("sounds/explosion.mp3").toString());
        isSpaceshipImage = true;

    }

    /**
     * setSize -- sets size of spaceship
     * @param width new width
     * @param height new height
     */
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
     * if spaceship is currently exploding, prohibits movement
     */
    @Override
    public void step() {


        if (this.audioClip.isPlaying()) {
            if (isSpaceshipImage){
                setImagetoExplosion();
            }
        }
        else {
            Point2D position = this.getPosition();
            this.setPosition(position.getX() + this.velocity.getX(), position.getY() + this.velocity.getY());
            if (!isSpaceshipImage){
                setImagetoSpaceship();
            }
        }
    }




    /**
     * makeSound -- plays explosion sound when the spaceship collides with an asteroid.
     */
    @Override
    public void makeSound(){
        this.audioClip.play();
    }

    /**
     * setImagetoExplosion -- sets image to explosion when we lose a life (temporary)
     */
    private void setImagetoExplosion() {
        this.isSpaceshipImage = false;
        oldPosition = this.getPosition();
        double newPosX = this.getPosition().getX()+this.getSize().getX()/2-150;
        double newPosY = this.getPosition().getY()+this.getSize().getY()/2-150;
        this.getChildren().remove(imageView);
        image = new Image(getClass().getResourceAsStream("/sample/img/explosion.gif"), 300, 300, true, false);
        imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().clear();
        this.setPosition(newPosX, newPosY);
        this.getChildren().add(imageView);

    }

    /**
     * setImagetoSpaceship -- sets image back to spaceship after an explosion.
     */
    private void setImagetoSpaceship() {
        this.getChildren().remove(imageView);
        image = new Image(getClass().getResourceAsStream("/sample/img/spaceship.png"));
        imageView = new ImageView();
        imageView.setImage(image);
        this.setPosition(oldPosition.getX(), oldPosition.getY());
        this.getChildren().clear();
        this.getChildren().add(imageView);
        this.isSpaceshipImage = true;
    }


}
