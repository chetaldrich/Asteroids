package sample;

import javafx.geometry.Point2D;

import java.util.List;

public interface ModelInterface {

    /**
     * checkGameCollisions -- checks the game for any collisions.
     * @return List objects that have collided and need to be deleted.
     */
    public boolean checkGameCollisions();

    /**
     * checkAsteroidBulletCollision -- checks for a Bullet and Asteroid collision, removes both objects from lists on collision.
     * @return boolean if there is a collision
     */
    public boolean checkAsteroidBulletCollision();

    /**
     * generateAsteroid -- creates a new Asteroid instance, and adds it to the current asteroidList.
d     */
    public void generateAsteroid();

    /**
     * generateBullet -- creates a new Bullet instance, and adds it to the current bulletList.
d     */
    public void generateBullet();


    /**
     * createNewShip -- creates a new Spaceship instance in the event of destruction due to collision or game initialization.
d     */
    public void createNewShip();

    /**
     * moveShip -- changes Ship velocity on method call (will be called from Controller on keypress).
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
     * updateLives -- updates current lives based on other method triggers, e.g. collision.
     * @param lives number of lives to add (negative values mean fewer lives)
     */
    public void updateLives(int lives);

    /**
     * updateScore -- updates current Score based on method triggers (survival time, bullet Asteroid collision)
     * @param points number of points to add (negative values mean lower score)
     */
    public void updateScore(int points);



}
