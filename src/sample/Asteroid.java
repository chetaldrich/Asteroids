package sample;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;


/**
 * Asteroid class. Constructs an asteroid for our game. Methods include get/setPosition, get/setVelocity, get/setRadius
 */
public class Asteroid extends Sprite implements AsteroidInterface{

    private Point2D velocity;
    //private Point2D position;
    private double radius;
    private Image image;
    private ImageView imageView;
    final private float id;


    /**
     * Constructor
     */
    public Asteroid(double screenWidth, double screenHeight){
        Random r = new Random();
        id = r.nextFloat();
        double yCoord = r.nextDouble()*screenHeight;
        this.setPosition(screenWidth, yCoord);
        this.velocity = new Point2D(-4, 0);
        this.radius = r.nextDouble()*10;
        this.image = new Image(getClass().getResourceAsStream("/sample/img/asteroid.png"));
        this.imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);

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

    public BoundingBox getBounds(){
        double xval= this.getPosition().getX();
        double yval = this.getPosition().getY();
        double xmin = xval - this.radius;
        double ymin = yval - this.radius;
        double widthAndHeight = 2*this.radius;
        return new BoundingBox(xmin, ymin, widthAndHeight, widthAndHeight);
    }
    /*/**
     * getPosition -- gets position of asteroid
     * @return Point2D of position
     */
    /*public Point2D getPosition() {
        Point2D position = new Point2D(this.getLayoutX(), this.getLayoutY());
        return position;
        return this.position;
    }

     /** setPosition -- sets position of asteroid
      * @param x  New x value
      * @param y  New y value
      */
    /*public void setPosition(double x, double y){
        this.position = new Point2D(x,y);

    }*/

    /*/**
     * vanish -- makes the asteroid disappear from screen
     * (so like when it smashes into  the spaceship)
     **/
    /*public void vanish() {

       //stub :)
    }*/

    /*/**
     * getVelocity -- gets velocity of asteroid
     * @return Point2D of velocity
     */
    /*public Point2D getVelocity(){
        return this.velocity;
    }


    /**
     * setVelocity --sets velocity of asteroid
     * @param vx New x velocity
     * @param vy New y velocity
     */
    /*public void setVelocity(double vx, double vy) {
        this.velocity = new Point2D(vx,vy);

    }

    /**
     * step -- sets new position according to velocity
     */
    /*public void step() {
        double xPos = this.position.getX();
        double yPos = this.position.getY();
        double xVel = this.velocity.getX();
        double yVel = this.velocity.getY();
        this.setPosition(xPos+xVel, yPos+yVel);
    }*/
    @Override
    public void makeSound(){

    }
}
