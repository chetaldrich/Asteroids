

package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.Random;


/**
 * Asteroid.java
 * Constructs a asteroids for our game. Methods include get/setPosition, get/setVelocity, get/setRadius
 * Chet Aldrich and Josie Bealle
 */
public class Asteroid extends Sprite {

    private Point2D velocity;
    private double radius;
    private Image image;
    private ImageView imageView;
    private int screenHeight = 700;
    private int screenWidth = 1200;
    private float id;
    private AudioClip audioClip;


    /**
     * Constructor
     */
    public Asteroid(){
        this.setName("asteroid");
        //
        Random r = new Random();
        id = r.nextFloat();

        //Set a random radius so asteroid size varies.
        this.radius = r.nextDouble()*60+60;
        double yCoord = r.nextDouble()*(screenHeight - 2*this.radius) + this.radius;

        //Set a random velocity.
        double randVelocity = id * -18;
        this.velocity = new Point2D(randVelocity, 0);
        this.setVelocity(randVelocity,0);


        this.setPosition(screenWidth, yCoord);
        this.image = new Image(getClass().getResourceAsStream("/sample/img/asteroid.png"), this.radius, this.radius, true, false);
        this.imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
        this.audioClip = new AudioClip(getClass().getResource("sounds/explosion.mp3").toString());

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

    @Override
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

    /**
     * makeSound -- make explosion sound when objects crash into this asteroid.
     */
    @Override
    public void makeSound(){
        this.audioClip.play();
    }



}
