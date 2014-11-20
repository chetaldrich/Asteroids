package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public Group spaceshipGroup;
    public Group asteroidGroup;
    public Group bulletGroup;
    private static Model spaceModel;
    final private double screenWidth = 1200;
    final private double screenHeight= 800;
    @FXML private Spaceship spaceship;

    final private double framesPerSecond = 20.0;
    private boolean isMovingUp;
    private boolean isMovingDown;

    private int score;
    private boolean paused;
    private Timer timer;

    public Controller(){

    }

    /**
     * Initializes game elements
     */
    public void initialize() {
        this.isMovingDown = false;
        this.isMovingUp = false;

        spaceModel = new Model(this.screenWidth, this.screenHeight);
        /*spaceModel.createNewShip();
        this.spaceship = spaceModel.getSpaceship();
        this.spaceshipGroup.getChildren().add(this.spaceship);*/
        /*Asteroid myAsteroid = this.spaceModel.generateAsteroid();
          this.asteroidGroup.getChildren().add(myAsteroid);

        for (Node node: this.asteroidGroup.getChildren()){
            Asteroid asteroid = (Asteroid) node;
            asteroid.setModel(spaceModel);
            this.asteroidGroup.getChildren().add(asteroid);
            System.out.println(spaceModel.getAsteroidList().size());
        }*/




        this.setUpAnimationTimer();
    }

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

        final long startTimeInMilliseconds = 0;
        final long repetitionPeriodInMilliseconds = 100;
        long frameTimeInMilliseconds = (long)(1000.0 / framesPerSecond);
        this.timer = new java.util.Timer();
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    private void updateAnimation() {
        this.spaceship.step();

        for (Node child : this.asteroidGroup.getChildren()){
            Asteroid asteroid = (Asteroid) child;
            asteroid.step();

        }
        for (Node child : this.bulletGroup.getChildren()){

            Bullet bullet = (Bullet) child;
            bullet.step();

        }

    }

    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        double spaceshipPosition = this.spaceship.getLayoutX();
        double stepSize = 10.0;
        if (code == KeyCode.UP || code == KeyCode.W) {
            // move ship up
            if (spaceshipPosition > stepSize) {
                this.spaceship.setLayoutX(this.spaceship.getLayoutX() - stepSize);
            } else {
                this.spaceship.setLayoutX(0);
            }
        } else if (code == KeyCode.RIGHT || code == KeyCode.S) {
            // move ship down
            if (spaceshipPosition + this.spaceship.getSize().getX() + stepSize < this.screenHeight) {
                this.spaceship.setLayoutX(this.spaceship.getLayoutX() + stepSize);
            } else {
                this.spaceship.setLayoutX(this.screenHeight - this.spaceship.getSize().getX());
            }
        }
    }


    /*public void handleKeyPress(KeyEvent event){
        KeyCode code = event.getCode();
        if (code == KeyCode.UP || code == KeyCode.K) {
            moveShipUp();
            this.isMovingUp = true;
            event.consume();
        }
        else if (code == KeyCode.DOWN || code == KeyCode.J) {
            moveShipDown();
            this.isMovingDown = true;
            event.consume();
        }
        else if (code == KeyCode.SPACE) {
            fireBullet();
            event.consume();
        }

    }
    public void handleKeyRelease(KeyEvent event){
        KeyCode code = event.getCode();
        if (code == KeyCode.UP || code == KeyCode.K) {
            //STOP move ship up
            this.isMovingUp = false;
            event.consume();
        }
        else if (code == KeyCode.DOWN || code == KeyCode.J) {
            //STOP move ship down
            this.isMovingDown = false;
            event.consume();
        }

    }*/


    private boolean isWithinYBounds(){
        double yVal = this.spaceship.getPosition().getY();
        return (yVal > 0) && (yVal < 800);
    }

    public void moveShipUp(){
        this.spaceship.setVelocity(4,0);

        while ((this.isMovingUp && !this.isMovingDown) && isWithinYBounds()){
            this.spaceship.step();
        }
        this.spaceship.setVelocity(0,0);

    }
    public void moveShipDown(){
        this.spaceship.setVelocity(-4,0);
        while ((this.isMovingUp && !this.isMovingDown) && isWithinYBounds()){
            this.spaceship.step();
        }
        this.spaceship.setVelocity(0,0);

    }
    public void fireBullet(){
        Bullet newBullet = spaceModel.generateBullet();
        this.bulletGroup.getChildren().add(newBullet);

    }

    private boolean isWithinXBounds(){
        double yVal = this.spaceship.getPosition().getY();
        return (yVal > 0) && (yVal < 800);
    }

    private boolean isBoxinScreen(BoundingBox boundingBox){
        if ((boundingBox.getMinX() <= 0) || (boundingBox.getMaxX() >= this.screenWidth)
                || (boundingBox.getMinY() <= 0) || (boundingBox.getMaxY() >= this.screenHeight)){
            return false;
        }
        return true;

    }

    public void cleanUpObjects(){
        for (Node node: this.asteroidGroup.getChildren()){
            Asteroid asteroid = (Asteroid) node;
            BoundingBox boundingBox = asteroid.getBounds();
            if (!isBoxinScreen(boundingBox)) {
                spaceModel.removeAsteroid(asteroid);
                this.asteroidGroup.getChildren().remove(asteroid);
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


        /*this.diceModel = new DiceModel(this.diceGroup.getChildren().size());

        int index = 0;
        double leftEdge = 0.0;
        final double PADDING = 15.0;
        for (Node node : this.diceGroup.getChildren()) {
            FourSidedDie die = (FourSidedDie)node;
            die.setDieIndex(index);
            die.setDiceModel(this.diceModel);
            die.setLayoutX(leftEdge);
            leftEdge += die.getWidth() + PADDING;
            die.update();
            index++;
        }

        this.updateDiceSumLabel();*/
    /*private void setUpAnimationTimer() {
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        updateAnimation();
                    }
                });
            }
        };

        final long startTimeInMilliseconds = 0;
        final long repetitionPeriodInMilliseconds = 100;
        long frameTimeInMilliseconds = (long)(1000.0 / framesPerSecond);
        Timer timer = new java.util.Timer();
        timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    private void updateAnimation() {
        for (Sprite sprite : this.asteroidList) {
            // Change sprite's velocity to create a bounce if it has hit a wall.
            Point2D position = sprite.getPosition();
            Point2D size = sprite.getSize();
            Point2D velocity = sprite.getVelocity();
            if (position.getX() + size.getX() >= screenWidth && velocity.getX() > 0) {
                sprite.setVelocity(-velocity.getX(), velocity.getY());
            } else if (position.getX() < 0  && velocity.getX() < 0) {
                sprite.setVelocity(-velocity.getX(), velocity.getY());
            } else if (position.getY() + size.getY() >= screenHeight && velocity.getY() > 0) {
                sprite.setVelocity(velocity.getX(), -velocity.getY());
            } else if (position.getY() < 0 && velocity.getY() < 0) {
                sprite.setVelocity(velocity.getX(), -velocity.getY());
                sprite.makeSound();
            }

            // Move the sprite.
            sprite.step();*/







}
