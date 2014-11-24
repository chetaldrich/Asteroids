/**
 * Controller.java
 * Manipulates and creates game elements in the Asteroids game.
 * Chet Aldrich and Josie Bealle
 */

package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.BoundingBox;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import java.util.ArrayList;
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
    private static AudioClip gameMusic;



    final private double framesPerSecond = 20.0;
    private int bulletCount;

    private int score;
    private boolean paused;
    private boolean wantMusicOn;
    private Timer timer;
    private Timer cleanupTimer;
    private boolean invincible;
    private int invincibleCount;

    public Controller(){

    }

    /**
     * initialize -- initializes game the beginning game elements and starts the animation timer.
     */
    public void initialize() {
        this.bulletCount = 0;
        spaceModel = new Model(this.screenWidth, this.screenHeight);
        this.gameMusic = new AudioClip(getClass().getResource("sounds/music.mp3").toString());
        this.gameMusic.play();
        this.wantMusicOn=true;
        this.invincible=false;

        initScore();
        this.setUpAnimationTimer();
    }



    /**
     * setUpAnimationTimer -- begins the timers for animations
     * Also establishes some timer tasks that will occur intermittently during the course of the game.
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

        TimerTask musicPlayer = new TimerTask(){
            public void run(){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        checkMusic();

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
        this.timer.scheduleAtFixedRate(musicPlayer, 0, 10000);
        this.timer.scheduleAtFixedRate(asteroidGeneration, 0, 1000);
    }

    /**
     * makeAsteroids -- generates Asteroids in the model and inserts them into the view for use in game.
     */
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

        this.spaceship.step();
        if (this.asteroidGroup.getChildren().size()>0) {
            for (Node child : this.asteroidGroup.getChildren()) {
                Asteroid asteroid = (Asteroid) child;
                asteroid.step();
            }
        }

            for (Node child : this.bulletGroup.getChildren()) {
                Bullet bullet = (Bullet) child;
                bullet.step();

            }

    }


    /**
     * checkMusic -- function that checks the in game music and if it is not currently playing, begins play.
     * Deals with the audio clip reaching the end of the track.
     */
    private void checkMusic(){
        if (!this.gameMusic.isPlaying()&& this.wantMusicOn){
            this.gameMusic.play();
        }
    }

    /**
     * checkGameCollisions -- checks the game for collisions between objects, and then calls the associated methods required for cleanup.
     */
    public void checkGameCollisions(){
        try {
            ArrayList collidedBAs = spaceModel.checkGameCollisions("bullet-asteroid", this.spaceship);


            if (collidedBAs.size() != 0) {
                for (int i = 0; i < collidedBAs.size(); i += 2) {
                    Bullet deadBullet= (Bullet) collidedBAs.get(i);
                    bulletGroup.getChildren().remove(deadBullet);
                    spaceModel.removeBullet(deadBullet);
                    this.bulletCount -= 1;
                    Asteroid deadAsteroid = (Asteroid) collidedBAs.get(i+1);
                    deadAsteroid.makeSound();
                    asteroidGroup.getChildren().remove(deadAsteroid);
                    spaceModel.removeAsteroid(deadAsteroid);
                    this.updateScore(50);
                }
            }
        } catch (Exception e) {

        }
        if (!this.invincible) {
            ArrayList collidedSAs = spaceModel.checkGameCollisions("spaceship-asteroid", this.spaceship);
            if (collidedSAs.size() != 0) {

                //one asteroid can only hit the ship at a time
                explodeTheShip(collidedSAs);
                updateScore(-1000);


            }
        }
        else{
            this.invincibleCount++;
            if (this.invincibleCount>50){
                this.invincible=false;
                this.invincibleCount=0;
            }

        }
    }

    /**
     * explodeTheShip -- given that the checkGameCollisions function finds that there was a collision between the spaceship and asteroid,
     * this function updates the lives, and calls functions for associated animations and cleanup.
     * @param collidedSAs A list of the collided asteroids and spaceship
     */
    private void explodeTheShip(ArrayList<Sprite> collidedSAs){
        this.invincible=true;
        spaceModel.updateLives(-1);
        Asteroid deadAsteroid = (Asteroid) collidedSAs.get(1);
        asteroidGroup.getChildren().remove(deadAsteroid);
        spaceModel.removeAsteroid(deadAsteroid);
        if (spaceModel.getLives()>0) {
            //make sound explodes the ship!
            spaceship.makeSound();
        }
        else{
            spaceshipGroup.getChildren().remove(collidedSAs.get(0));
//            Main.goToGameOver();
        }

    }

    /**
     * updateScore -- updates the score in the model and in game
     * @param value amount by which to increase or decrease the score. Can be negative or positive.
     */
    private void updateScore(int value){
        spaceModel.updateScore(value);
        spaceModel.getScoreboard().getScoreLabel().setText(String.format("Score: %d\nLives: %d", spaceModel.getScoreboard().getScore(),
                                                                                                 spaceModel.getScoreboard().getLives()));
        scoreboardGroup.getChildren().remove(spaceModel.getScoreboard().getScoreLabel());
        scoreboardGroup.getChildren().add(spaceModel.getScoreboard().getScoreLabel());
    }

    private void initScore(){
        spaceModel.getScoreboard().getScoreLabel().setText(String.format("Score: %d\nLives: %d", spaceModel.getScoreboard().getScore(),
                spaceModel.getScoreboard().getLives()));
        scoreboardGroup.getChildren().add(spaceModel.getScoreboard().getScoreLabel());

    }


    /**
     * handle -- implements keystroke handling, including spaceship movement and bullet firing.
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        double spaceshipYPosition = this.spaceship.getLayoutY();
        double spaceshipXPosition = this.spaceship.getLayoutX();
        double stepSize = 15.0;
        if (code == KeyCode.UP || code == KeyCode.K) {
            // move ship up
            if (spaceshipYPosition > stepSize) {
                this.spaceship.setLayoutY(this.spaceship.getLayoutY() - stepSize);
            } else {
                this.spaceship.setLayoutY(this.screenHeight - this.spaceship.getSize().getY());
            }

        } else if (code == KeyCode.DOWN || code == KeyCode.J) {
            // move ship down
            if (spaceshipYPosition + this.spaceship.getSize().getY() + stepSize < this.screenHeight) {
                this.spaceship.setLayoutY(this.spaceship.getLayoutY() + stepSize);
            } else {
                this.spaceship.setLayoutY(this.screenHeight - this.spaceship.getSize().getY());
            }

        } else if (code == KeyCode.LEFT || code == KeyCode.H) {
            // move ship left
            if (spaceshipXPosition > stepSize) {
                this.spaceship.setLayoutX(this.spaceship.getLayoutX() - stepSize);
            } else {
                this.spaceship.setLayoutX(0);
            }

        } else if (code == KeyCode.RIGHT || code == KeyCode.L) {
            // move ship right
            if (spaceshipXPosition + this.spaceship.getSize().getX() + stepSize < this.screenWidth) {
                this.spaceship.setLayoutX(this.spaceship.getLayoutX() + stepSize);
            } else {
                this.spaceship.setLayoutX(this.screenWidth - this.spaceship.getSize().getX());
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
        newBullet.makeSound();
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

    }

}
