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
    @FXML private Scoreboard scoreboard;



    final private double framesPerSecond = 20.0;
    private boolean isMovingUp;
    private boolean isMovingDown;
    private int bulletCount;

    private int score;
    private boolean paused;
    private Timer timer;
    private Timer cleanupTimer;

    public Controller(){

    }

    /**
     * initialize -- initializes game the beginning game elements and starts the animation timer.
     */
    public void initialize() {
        this.isMovingDown = false;
        this.isMovingUp = false;
        this.bulletCount = 0;
        spaceModel = new Model(this.screenWidth, this.screenHeight);



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
        TimerTask cleanUpTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        cleanUpObjects();

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


        //I thought we needed this, but maybe not?....
        TimerTask collisionTask = new TimerTask(){
            public void run(){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        checkGameCollisions();

                    }
                });
            }
        };


        final long startTimeInMilliseconds = 0;
        final long repetitionPeriodInMilliseconds = 100;
        long frameTimeInMilliseconds = (long)(1000.0 / framesPerSecond);
        this.timer = new java.util.Timer();
        this.cleanupTimer = new Timer();
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
        this.cleanupTimer.schedule(cleanUpTask, 100, frameTimeInMilliseconds);
        this.cleanupTimer.schedule(collisionTask, 10, 50);
        this.timer.scheduleAtFixedRate(asteroidGeneration, 0, 2500);
    }
    public void makeAsteroids(){
        Asteroid newAsteroid = this.spaceModel.generateAsteroid();
        try{
            this.asteroidGroup.getChildren().add(newAsteroid);
        }
        catch (Exception e){

        }

    }

    /**
     * updateAnimation -- calls functions to handle essential animation elements.
     * Examples include step methods for object movement in-game and collision checking.
     */
    private void updateAnimation() {
        updateScore();

        this.spaceship.step();
        if (this.asteroidGroup.getChildren().size()>0) {
            for (Node child : this.asteroidGroup.getChildren()) {
                Asteroid asteroid = (Asteroid) child;
                asteroid.step();
            }
        }

        //if (this.bulletCount>0) {
            for (Node child : this.bulletGroup.getChildren()) {
                Bullet bullet = (Bullet) child;
                bullet.step();

            }
        //}
        //checkGameCollisions();

    }

    public void checkGameCollisions(){
        if (this.bulletCount>0) {
            System.out.println(this.bulletCount);
        }
            try {
                ArrayList collidedBAs = spaceModel.checkGameCollisions("bullet-asteroid", this.spaceship);


                if (collidedBAs.size() != 0) {
                    for (int i = 0; i < collidedBAs.size(); i += 2) {
                        Bullet deadBullet= (Bullet) collidedBAs.get(i);
                        bulletGroup.getChildren().remove(deadBullet);
                        spaceModel.removeBullet(deadBullet);
                        this.bulletCount -= 1;
                        Asteroid deadAsteroid = (Asteroid) collidedBAs.get(i+1);
                        asteroidGroup.getChildren().remove(deadAsteroid);
                        spaceModel.removeAsteroid(deadAsteroid);
                    }
                }
            } catch (Exception e) {

            }
        //}
//        ArrayList collidedSAs = spaceModel.checkGameCollisions("spaceship-asteroid", this.spaceship);
//        if (collidedSAs.size()!=0){
//            //one asteroid can only hit the ship at a time
//             spaceshipGroup.getChildren().remove(collidedSAs.get(0));
//             asteroidGroup.getChildren().remove(collidedSAs.get(1));
//        }
    }

    private void updateScore(){
        spaceModel.updateScore(1);
        spaceModel.getScoreboard().getScoreLabel().setText(String.format("Score: %d\nLives: %d", spaceModel.getScoreboard().getScore(),
                                                                                                 spaceModel.getScoreboard().getLives()));
        scoreboardGroup.getChildren().remove(spaceModel.getScoreboard().getScoreLabel());
        scoreboardGroup.getChildren().add(spaceModel.getScoreboard().getScoreLabel());
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
     * isAsteroidInScreen -- determines whether a given asteroid is still visible.
     * @param asteroid the asteroid we're looking at
     * @return boolean whether asteroid is inside game screen.
     */
    private boolean isAsteroidInScreen(Asteroid asteroid){
        if (asteroid.getPosition().getX() + asteroid.getRadius() <=0){
            return false;
        }
        return true;
    }
    /**
     * isBulletInScreen -- determines whether a given bullet is still visible.
     * @param bullet the bullet we're looking at
     * @return boolean whether bullet is inside game screen.
     */
    private boolean isBulletInScreen(Bullet bullet){
        if (bullet.getPosition().getX() - bullet.getSize().getX() >= this.screenWidth){
            return false;
        }
        return true;
    }

    /**
     * cleanUpObjects -- removes objects that have collided with each other, and instantiates new ones if necessary.
     */
    public void cleanUpObjects(){
        try {
            for (Node node : this.asteroidGroup.getChildren()) {
                Asteroid asteroid = (Asteroid) node;
                if (!isAsteroidInScreen(asteroid)) {
                    spaceModel.removeAsteroid(asteroid);
                    this.asteroidGroup.getChildren().remove(asteroid);

                }
            }
        }
        catch (Exception e){}
        //if (bulletCount>0) {
          try {
              for (Node node : this.bulletGroup.getChildren()) {
                  Bullet bullet = (Bullet) node;
                  BoundingBox boundingBox = bullet.getBounds();
                  if (!isBulletInScreen(bullet)) {
                      spaceModel.removeBullet(bullet);
                      this.bulletGroup.getChildren().remove(bullet);
                      bulletCount--;
                  }
              }
          }
          catch (Exception e){}
        //}
    }










}
