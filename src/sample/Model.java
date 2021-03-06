

package sample;


import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Model.java
 * Manages the current game state of our program, and provides information to the controller for modification.
 * Chet Aldrich and Josie Bealle
 */
public class Model {

    private static ArrayList asteroids;
    private static Spaceship spaceship;
    private static ArrayList bullets;
    private static Scoreboard scoreboard;
    private static ArrayList explosions;
    private double screenWidth;
    private double screenHeight;

    /**
     * Model Constructor
     * Will create a beginning game state in the absence of one.
     */
    public Model(double screenWidth, double screenHeight) {
        bullets = new ArrayList<Bullet>();
        asteroids = new ArrayList<Asteroid>();
        scoreboard = new Scoreboard();
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    /**
     * checkGameCollisions -- checks for any collisions in the sprite classes.
     * @param type The type of collision to check( "bullet-asteroid" or "spaceship-asteroid)
     * @param instantiatedShip The spaceship to check collisions with, if neccessary
     *                         because the ship is instantiated in the fxml file,
     *                         it is neccesssary to pass it in
     * @return ArrayList of the sprites that collided
     */
    public ArrayList<Sprite> checkGameCollisions(String type, Spaceship instantiatedShip){

        int bulletListLength = bullets.size();
        int asteroidListLength = asteroids.size();
        ArrayList<Sprite> collidedSprites = new ArrayList<Sprite>();
        //System.out.println(bulletListLength);
        for (int i = 0; i < asteroidListLength; i++) {
            Asteroid asteroid = (Asteroid) asteroids.get(i);
            if (type.equals("bullet-asteroid")) {

                for (int j = 0; j < bulletListLength; j++) {
                    Bullet bullet = (Bullet) bullets.get(j);
                    if (collided(asteroid, bullet)) {
                        collidedSprites.add(bullet);
                        collidedSprites.add(asteroid);

                    }
                }

            } else if (type.equals("spaceship-asteroid")) {
                if (collided(asteroid, instantiatedShip)) {
                    collidedSprites.add(instantiatedShip);
                    collidedSprites.add(asteroid);

                }
            }
        }
        return collidedSprites;
    }

    /**
     * collided -- Checks to see if a particular two sprites collided.
     * @param asteroid asteroid to check
     * @param sprite2 Second sprite to check against
     * @return boolean true if sprites collided, false if sprites did not collide
     */
    public boolean collided(Asteroid asteroid, Sprite sprite2){
        BoundingBox asteroidBounds = asteroid.getBounds();
        BoundingBox sprite2Bounds = sprite2.getBounds();
        BoundingBox asteroidSmallerBox = new BoundingBox (asteroidBounds.getMinX()*1.1,
                asteroidBounds.getMinY()*1.1, asteroidBounds.getWidth()*.9, asteroidBounds.getHeight()*.9);
        if (asteroidSmallerBox.intersects(sprite2Bounds)){
            return true;
        }

        return false;



    }

    /**
     * generateAsteroid -- creates a new Asteroid instance, and adds it to the current asteroidList.
     * @return asteroid created
     */
    public Asteroid generateAsteroid(){
       Asteroid newAsteroid = new Asteroid();
       asteroids.add(newAsteroid);
       return newAsteroid;
    }

    /**
     * generateBullet -- creates a new Bullet instance, and adds it to the current bulletList.
     * @return bullet created
     */
    public Bullet generateBullet(){
        Bullet newBullet = new Bullet();
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
     * getLives -- gets number of lives
     * @return number of lives
     */
    public int getLives(){
        return scoreboard.getLives();
    }

    /**
     * updateScore -- updates current Score based on method triggers (survival time, bullet Asteroid collision)
     * @param points number of points to add (negative values mean lower score)
     */
    public void updateScore(int points){
        int currentScore = scoreboard.getScore();
        if (currentScore + points < 0){
            scoreboard.setScore(0);
        }else{
            scoreboard.setScore(currentScore + points);
        }

    }
    /**
     * removes an asteroid from the model
     * @param asteroid
     */
    public void removeAsteroid(Asteroid asteroid){
        asteroids.remove(asteroid);

    }

    /**
     * removes a bullet from the model
     * @param bullet
     */
    public void removeBullet(Bullet bullet){
        bullets.remove(bullet);

    }



}
