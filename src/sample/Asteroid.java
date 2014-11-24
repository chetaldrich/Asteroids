/**
 * Asteroid.java
 * Constructs a asteroids for our game. Methods include get/setPosition, get/setVelocity, get/setRadius
 * Chet Aldrich and Josie Bealle
 */

package sample;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.Random;


/**
 *
 */
public class Asteroid extends Sprite implements AsteroidInterface{

    private Point2D velocity;
    //private Point2D position;
    private double radius;
    private Image image;
    private ImageView imageView;
    private int screenHeight = 700;
    private int screenWidth = 1200;
    private float id;
    private AudioClip audioClip;
    private boolean isAsteroidImage;
    private Point2D oldPosition;


    /**
     * Constructor
     */
    public Asteroid(){
        this.setName("asteroid");
        Random r = new Random();
        id = r.nextFloat();
        this.radius = r.nextDouble()*60+60;
        double yCoord = r.nextDouble()*(screenHeight - 2*this.radius) + this.radius;
        double randVelocity = id * -18;
        this.velocity = new Point2D(randVelocity, 0);
        this.setPosition(screenWidth, yCoord);
        this.image = new Image(getClass().getResourceAsStream("/sample/img/asteroid.png"), this.radius, this.radius, true, false);
        this.imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
        this.audioClip = new AudioClip(getClass().getResource("sounds/explosion.mp3").toString());
        isAsteroidImage = true;

    }

    public float getObjId(){
        return this.id;
    }

    @Override
    public void setSize(double width, double height) {
        super.setSize(width, height);
        this.getChildren().remove(imageView);
        image = new Image(getClass().getResourceAsStream("/sample/img/asteroid.png"), width, height, true,false);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
    }

    /**
     * getRadius -- returns radius of asteroid
     * @return double of radius
     */
    public double getRadius(){
        return this.radius;
    }

    /**
     * setRadius -- sets radius of asteroid
     * @param newRadius of  new radius
     */
    public void setRadius(double newRadius){
        this.radius = newRadius;
        this.setSize(newRadius, newRadius);
    }



    /**
     * step -- sets new position according to velocity
     */
    public void step() {
        double xPos = this.getPosition().getX();
        double yPos = this.getPosition().getY();
        double xVel = this.velocity.getX();
        double yVel = this.velocity.getY();
        this.setPosition(xPos+xVel, yPos+yVel);
    }


    @Override
    public void makeSound(){
        this.audioClip.play();
    }

    private void setImagetoExplosion() {
        this.isAsteroidImage = false;
        oldPosition = this.getPosition();
        double newPosX = this.getPosition().getX()+this.getSize().getX()/2-100;
        double newPosY = this.getPosition().getY()+this.getSize().getY()/2-110;
        this.getChildren().remove(imageView);
        image = new Image(getClass().getResourceAsStream("/sample/img/explosion.gif"), 200, 200, true, false);
        imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().clear();
        this.setPosition(newPosX, newPosY);
        this.getChildren().add(imageView);

    }

    private void setImagetoAsteroid() {
        this.isAsteroidImage = true;
        this.getChildren().remove(imageView);
        image = new Image(getClass().getResourceAsStream("/sample/img/asteroid.png"));
        imageView = new ImageView();
        imageView.setImage(image);
        this.setPosition(oldPosition.getX(), oldPosition.getY());
        this.getChildren().clear();
        this.getChildren().add(imageView);
    }
}
