package sample;


import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private static ArrayList asteroids;
    private static Spaceship spaceship;
    private static ArrayList bullets;
    private static Scoreboard scoreboard;
    private double screenWidth;
    private double screenHeight;

    /**
     * Model Constructor
     * Will create a beginning game state in the absence of one.
     */
    public Model(double screenWidth, double screenHeight) {
        bullets = new ArrayList<Bullet>();
        asteroids = new ArrayList<Asteroid>();
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.createScoreboard();
        this.createNewShip();
    }

    /**
     * checkGameCollisions -- checks for any collisions in the sprite classes.
     * @return ArrayList of the sprites that collided
     */
    public ArrayList<Sprite> checkGameCollisions(){
        int bulletListLength = bullets.size();
        int asteroidListLength = asteroids.size();

        for (int i = 0; i < bulletListLength; i++){
            Bullet bullet = (Bullet) bullets.get(i);


            for (int j = 0; j < asteroidListLength; j++){
                Asteroid asteroid = (Asteroid) asteroids.get(j);
                if (collided(spaceship, asteroid)){
                   ArrayList<Sprite> collidedSprites = new ArrayList<Sprite>();
                   collidedSprites.add(spaceship);
                   collidedSprites.add(asteroid);
                   return collidedSprites;
                }else if (collided(bullet, asteroid)){
                    ArrayList<Sprite> collidedSprites = new ArrayList<Sprite>();
                    collidedSprites.add(bullet);
                    collidedSprites.add(asteroid);
                    return collidedSprites;
                }
            }
        }
        //TODO: find something better than just returning an empty list, although this might be OK.
        return new ArrayList<Sprite>();
    }

    /**
     * collided -- Checks to see if a particular two sprites collided.
     * @param sprite1 First sprite to check
     * @param sprite2 Second sprite to check against
     * @return boolean true if sprites collided, false if sprites did not collide
     * TODO: make this smarter and check based on the size of the object
     */
    public boolean collided(Sprite sprite1, Sprite sprite2){
        Point2D sprite1Position = sprite1.getPosition();
        Point2D sprite2Position = sprite2.getPosition();
        return sprite1Position.equals(sprite2Position);
    }

    /**
     * generateAsteroid -- creates a new Asteroid instance, and adds it to the current asteroidList.
     */
    public Asteroid generateAsteroid(){
       Asteroid newAsteroid = new Asteroid(screenWidth, screenHeight);
       asteroids.add(newAsteroid);
       return newAsteroid;
    }

    /**
     * generateBullet -- creates a new Bullet instance, and adds it to the current bulletList.
     */
    public Bullet generateBullet(){
        Bullet newBullet = new Bullet(spaceship.getPosition());
        bullets.add(newBullet);
        return newBullet;
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

    /**
     * Point2D asteroidPosition = asteroid.getPosition();
     double asteroidRadius = asteroid.getRadius();
     double lowerXBound = asteroidPosition.getX() - asteroidRadius;
     double upperXBound = asteroidPosition.getX() + asteroidRadius;
     double lowerYBound = asteroidPosition.getY() - asteroidRadius;
     double upperYBound = asteroidPosition.getY() + asteroidRadius;
     if (lowerXBound < bulletPosition.getX() && bulletPosition.getX() < upperXBound &&
     lowerYBound < bulletPosition.getY() && bulletPosition.getY() < upperYBound){
     return true;
     */


}
