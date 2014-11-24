/**
 * Spaceship.java
 * Spaceship class: Constructs a spaceship for our game. Methods include get/setPosition, get/setVelocity, and step
 * Chet Aldrich and Josie Bealle
 */

package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;


public class Spaceship extends Sprite implements SpaceshipInterface {

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

    //is this even called????
    //TODO: GET RID OF THIS IN SPRITE CLASS!
    public String getSpriteType(){
        return "spaceship";
    }

    @Override
    public void makeSound(){
        this.audioClip.play();
    }
    
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
