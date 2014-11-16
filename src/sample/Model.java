package sample;


import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List asteroids;
    private Spaceship spaceship;
    private List bullets;
    private Scoreboard scoreboard;
    private double screenWidth;
    private double screenHeight;

    /**
     * Model Constructor
     * Will create a beginning game state in the absence of one.
     */
    public Model(double screenWidth, double screenHeight) {
        bullets = new ArrayList<Bullet>();
        asteroids= new ArrayList<Asteroid>();
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.createScoreboard();
        this.createNewShip();
    }

    /**
     * checkShipAsteroidCollision -- checks for a Ship and Asteroid collision, updates Lives on collision.
     * @return boolean if there is a collision
     */
    public boolean checkShipAsteroidCollision(){
        return false;

    }

    /**
     * checkAsteroidBulletCollision -- checks for a Ship and Asteroid collision, removes both objects from lists on collision.
     * @return boolean if there is a collision
     */
    public boolean checkAsteroidBulletCollision(){
        return false;
    }

    /**
     * generateAsteroid -- creates a new Asteroid instance, and adds it to the current asteroidList.
     */
    public void generateAsteroid(){
       Asteroid newAsteroid = new Asteroid(screenWidth, screenHeight);
       asteroids.add(newAsteroid);
    }

    /**
     * generateBullet -- creates a new Bullet instance, and adds it to the current bulletList.
     */
    public void generateBullet(){
        Bullet newBullet = new Bullet(spaceship.getPosition());
        bullets.add(newBullet);
    }


    /**
     * createNewShip -- creates a new Spaceship instance in the event of destruction due to collision or game initialization.
     */
    public void createNewShip(){
        spaceship = new Spaceship();
    }

    /**
     * moveShip -- changes Ship velocity on method call (will be called from Controller on keypress).
     */
    public void moveShip(Point2D additionalSpeed){
        Point2D velocity = spaceship.getVelocity();
        spaceship.setVelocity(velocity.getX() + additionalSpeed.getX(), velocity.getY() + additionalSpeed.getY());
    }

    /**
     * getSpaceShip -- gets the current Spaceship instance in the model.
     * @return Spaceship current spaceship
     */
    public Spaceship getSpaceship(){
        return new Spaceship();
    }

    /**
     * getAsteroidList -- gets the current asteroidList in the model.
     * @return List current active asteroids
     */
    public List getAsteroidList(){
        return asteroids;
    }

    /**
     * getBulletList -- gets the current bulletList in the model.
     * @return List current active bullets
     */
    public List getBulletList(){
        return bullets;
    }

    /**
     * getScoreboard -- gets the current Scoreboard in the model.
     * @return Scoreboard scoreboard
     */
    public Scoreboard getScoreboard(){
        return scoreboard;
    }

    /**
     * createScoreboard --  creates the Scoreboard.
     */
    public void createScoreboard(){
        scoreboard = new Scoreboard();
    }

    /**
     * updateLives -- updates current lives based on other method triggers, e.g. collision.
     * @param lives number of lives to add (negative values mean fewer lives)
     */
    public void updateLives(int lives){
        int currentLives = scoreboard.getLives();
        scoreboard.setLives(currentLives + lives);
    }

    /**
     * updateScore -- updates current Score based on method triggers (survival time, bullet Asteroid collision)
     * @param points number of points to add (negative values mean lower score)
     */
    public void updateScore(int points){
        int currentScore = scoreboard.getScore();
        scoreboard.setScore(currentScore + points);
    }



}
