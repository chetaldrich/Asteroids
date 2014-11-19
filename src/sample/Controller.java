package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import sample.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    public Group spaceshipGroup;
    public
    private static Model spaceModel;
    private double screenWidth;
    private double screenHeight;
    private static Spaceship spaceShip;
    private static List<Asteroid> asteroidList;
    private static List<Bullet> bulletList;
    private double framesPerSecond;



    public Controller(){

    }

    /**
     * Initializes game elements
     */
    public void initialize() {
        this.screenHeight = 800;
        this.screenWidth = 1200;
        this.framesPerSecond = 20.0;
        this.spaceModel = new Model(this.screenWidth, this.screenHeight);
        spaceModel.createNewShip();
        spaceModel.generateAsteroid();
        this.spaceShip = spaceModel.getSpaceship();

        //this.setUpAnimationTimer();
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
