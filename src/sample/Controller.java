/**
 * Controller.java
 * Manipulates and creates game elements in the Asteroids game.
 * Chet Aldrich and Josie Bealle
 */

package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements EventHandler<KeyEvent> {
    @FXML public Group spaceshipGroup;
    @FXML public Group asteroidGroup;
    @FXML public Group bulletGroup;
    public Group scoreboardGroup;
    private static Model spaceModel;
    final private double screenWidth = 1200;
    final private double screenHeight= 700;
    @FXML private Spaceship spaceship;
    @FXML private ArrayList<Asteroid> asteroidList;


    final private double framesPerSecond = 20.0;
    private boolean isMovingUp;
    private boolean isMovingDown;
    private int bulletCount;

    private int score;
    private boolean paused;
    private Timer timer;

    public Controller(){

    }

    /**
     * initialize -- initializes game the beginning game elements and starts the animation timer.
     */
    public void initialize() {
        this.isMovingDown = false;
        this.isMovingUp = false;
        this.bulletCount=0;

        this.spaceModel = new Model(this.screenWidth, this.screenHeight);

        this.setUpAnimationTimer();
    }

    /**
     * setUpAnimationTimer -- begins the timer for animations
     */
    private void setUpAnimationTimer() {
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                            updateAnimation();
                    }
                });
            }
        };
        TimerTask asteroidGeneration = new TimerTask(){
            public void run(){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                       makeAsteroids();
                    }
                });
            }
        };

        final long startTimeInMilliseconds = 0;
        final long repetitionPeriodInMilliseconds = 100;
        long frameTimeInMilliseconds = (long)(1000.0 / framesPerSecond);
        this.timer = new java.util.Timer();
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
        this.timer.scheduleAtFixedRate(asteroidGeneration, 0, 2500);
    }
    public void makeAsteroids(){
        this.asteroidGroup.getChildren().add(spaceModel.generateAsteroid());
    }

    /**
     * updateAnimation -- calls functions to handle essential animation elements.
     * Examples include step methods for object movement in-game and collision checking.
     */
    private void updateAnimation() {
        this.spaceship.step();
        if (this.asteroidGroup.getChildren().size()>0) {
            for (Node child : this.asteroidGroup.getChildren()) {
                Asteroid asteroid = (Asteroid) child;
                asteroid.step();
            }
        }

        if (this.bulletCount>0) {
            for (Node child : this.bulletGroup.getChildren()) {
                Bullet bullet = (Bullet) child;
                bullet.step();

            }
        }
        ArrayList collidedBAs = spaceModel.checkGameCollisions("bullet-asteroid");
        ArrayList collidedSAs = spaceModel.checkGameCollisions("asteroid-spaceship");
        if (collidedBAs.size()!=0){
            for (int i = 0; i<collidedBAs.size(); i+=2){
                bulletGroup.getChildren().remove(collidedBAs.get(i));
                this.bulletCount-=1;
                asteroidGroup.getChildren().remove(collidedBAs.get(i + 1));
            }
        }
        if (collidedSAs.size()!=0){
            //one asteroid can only hit the ship at a time
             spaceshipGroup.getChildren().remove(collidedBAs.get(0));
             asteroidGroup.getChildren().remove(collidedBAs.get(1));
        }
    }



    /**
     * handle -- implements keystroke handling, including spaceship movement and bullet firing.
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        double spaceshipPosition = this.spaceship.getLayoutY();
        double stepSize = 10.0;
        if (code == KeyCode.UP || code == KeyCode.K) {
            // move ship up
            if (spaceshipPosition > stepSize) {
                this.spaceship.setLayoutY(this.spaceship.getLayoutY() - stepSize);
            } else {
                this.spaceship.setLayoutY(0);
            }

        } else if (code == KeyCode.DOWN || code == KeyCode.J) {
            // move ship down
            if (spaceshipPosition + this.spaceship.getSize().getY() + stepSize < this.screenHeight) {
                this.spaceship.setLayoutY(this.spaceship.getLayoutY() + stepSize);
            } else {
                this.spaceship.setLayoutY(this.screenHeight - this.spaceship.getSize().getY());
            }

        }
        else if (code == KeyCode.SPACE) {
            fireBullet();
        }
    }


    /**
     * fireBullet -- fires a bullet from the spaceship by creating a new Bullet instance at the location of the spaceship.
     */
    public void fireBullet(){
        double spaceshipXOffset = spaceship.getSize().getX() - 30;
        double spaceshipYOffset = spaceship.getSize().getY()/2;
        double bulletXVal = spaceship.getPosition().getX() + spaceshipXOffset;
        double bulletYVal = spaceship.getPosition().getY() + spaceshipYOffset;
        Bullet newBullet = spaceModel.generateBullet();
        newBullet.setPosition(bulletXVal, bulletYVal);
        this.bulletCount+=1;
        this.bulletGroup.getChildren().add(newBullet);

    }


    /**
     * isBoxinScreen -- determines whether a game object's bounding box is within the game view.
     * @param boundingBox the bounds of a particular game object (requires boundingBox type, found with getBounds method)
     * @return boolean whether object is inside game screen.
     */
    private boolean isBoxinScreen(BoundingBox boundingBox){
        if ((boundingBox.getMinX() <= 0) || (boundingBox.getMaxX() >= this.screenWidth)
                || (boundingBox.getMinY() <= 0) || (boundingBox.getMaxY() >= this.screenHeight)){
            return false;
        }
        return true;
    }

    /**
     * cleanUpObjects -- removes objects that have collided with each other, and instantiates new ones if necessary.
     */
    public void cleanUpObjects(){
        for (Node node: this.asteroidGroup.getChildren()){
            Asteroid asteroid = (Asteroid) node;
            BoundingBox boundingBox = asteroid.getBounds();
            if (!isBoxinScreen(boundingBox)) {
                spaceModel.removeAsteroid(asteroid);
                this.asteroidGroup.getChildren().remove(asteroid);
                spaceModel.generateAsteroid();
            }
        }
        for (Node node: this.bulletGroup.getChildren()){
            Bullet bullet = (Bullet) node;
            BoundingBox boundingBox = bullet.getBounds();
            if (!isBoxinScreen(boundingBox)){
                spaceModel.removeBullet(bullet);
                this.bulletGroup.getChildren().remove(bullet);
            }
        }

    }










}
