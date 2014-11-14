package sample;

import java.util.List;

public interface ModelInterface {

    /**
     * checkShipAsteroidCollision -- checks for a Ship and Asteroid collision, updates Lives on collision.
     * @return void
     */
    public void checkShipAsteroidCollision();

    /**
     * checkAsteroidBulletCollision -- checks for a Ship and Asteroid collision, removes both objects from lists on collision.
     * @return void
     */
    public void checkAsteroidBulletCollision();

    /**
     * generateAsteroid -- creates a new Asteroid instance, and adds it to the current asteroidList.
     * @return void
     */
    public void generateAsteroid();

    /**
     * generateBullet -- creates a new Bullet instance, and adds it to the current bulletList.
     * @return void
     */
    public void generateBullet();


    /**
     * createNewShip -- creates a new Spaceship instance in the event of destruction due to collision or game initialization.
     * @return void
     */
    public void createNewShip();

    /**
     * moveShip -- changes Ship velocity on method call (will be called from Controller on keypress).
     * @return void
     */
    public void moveShip();

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
     * @return void
     */
    public void createScoreboard();

    /**
     * updateLives -- updates current lives based on other method triggers, e.g. collision.
     * @param lives number of lives to add or deduct
     * @return void
     */
    public void updateLives(int lives);

    /**
     * updateScore -- updates current Score based on method triggers (survival time, bullet Asteroid collision)
     * @param points number of points to add or deduct
     * @return void
     */
    public void updateScore(int points);

    p

}
