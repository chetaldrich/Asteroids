package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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

public class Controller {
    public Group spaceshipGroup;
    public Group asteroidGroup;
    public Group bulletGroup;
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
        this.spaceship = spaceModel.getSpaceship();

        spaceModel.generateAsteroid();

        for (int i = 0; i < 2; i++){
            Node node = new Node();
            Asteroid asteroid = (Asteroid) node;
            asteroid.setModel(spaceModel);
            this.asteroidGroup.getChildren().add(asteroid);
            System.out.println(spaceModel.getAsteroidList().size());

        }




        //this.setUpAnimationTimer();
    }

    public void handleKeyPress(KeyEvent event){
        KeyCode code = event.getCode();
        if (code == KeyCode.UP || code == KeyCode.K) {
            //move ship up
            event.consume();
        }
        else if (code == KeyCode.DOWN || code == KeyCode.J) {
            //move ship down
            event.consume();
        }
        else if (code == KeyCode.SPACE) {
            //fire bullets
            event.consume();
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
