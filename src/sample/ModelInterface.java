
package sample;

import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * ModelInterface.java
 * Manages the current game state of our program, and provides information to the controller for modification.
 * Chet Aldrich and Josie Bealle
 */
public interface ModelInterface {

    /**
     * checkGameCollisions -- checks the game for any collisions.
     * @return List objects that have collided and need to be deleted.
     */
    public ArrayList<Sprite> checkGameCollisions();

    /**
     * collided -- Checks to see if a particular two sprites collided.
     * @param asteroid asteroid to check
     * @param sprite2 Second sprite to check against
     * @return boolean true if sprites collided, false if sprites did not collide
     */
    public boolean collided(Asteroid asteroid, Sprite sprite2);

    /**
     * generateAsteroid -- creates a new Asteroid instance, and adds it to the current asteroidList.
     * @return asteroid created
     */
    public Asteroid generateAsteroid();

    /**
     * generateBullet -- creates a new Bullet instance, and adds it to the current bulletList.
     * @return bullet created
d     */
    public Bullet generateBullet();


    /**
     * createNewShip -- creates a new Spaceship instance in the event of destruction due to collision or game initialization.
d     */
    public void createNewShip();

    /**
     * moveShip -- changes Ship velocity on method call (will be called from Controller on keypress).
     * @param additionalSpeed speed to add
d     */
    public void moveShip(Point2D additionalSpeed);

    /**
     * getSpaceShip -- gets the current Spaceship instance in the model.
     * @return Spaceship current spaceship
     */
    public Spaceship getSpaceship();

    /**
     * getAsteroidList -- gets the current asteroidList in the model.
     * @return List current active asteroids
     */
    public List getAsteroidList();

    /**
     * getBulletList -- gets the current bulletList in the model.
     * @return List current active bullets
     */
    public List getBulletList();

    /**
     * getScoreboard -- gets the current Scoreboard in the model.
     * @return Scoreboard scoreboard
     */
    public Scoreboard getScoreboard();

    /**
     * createScoreboard --  creates the Scoreboard.
     */
    public void createScoreboard();

    /**
     * getLives -- gets number of lives
     * @return number of lives
     */
    public int getLives();

    /**
     * updateLives -- updates current lives based on other method triggers, e.g. collision.
     * @param lives number of lives to add (negative values mean fewer lives)
     */
    public void updateLives(int lives);

    /**
     * updateScore -- updates current Score based on method triggers (survival time, bullet Asteroid collision)
     * @param points number of points to add (negative values mean lower score)
     */
    public void updateScore(int points);

    /**
     * removes an asteroid from the model
     * @param asteroid
     */
    public void removeAsteroid(Asteroid asteroid);

    /**
     * removes a bullet from the model
     * @param bullet
     */
    public void removeBullet(Bullet bullet);

}
