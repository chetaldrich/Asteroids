package sample;


import java.util.List;

public class Model {

    private List asteroids;
    private Spaceship spaceship;
    private List bullets;

    /**
     * Model Constructor
     * Will create a beginning game state in the absence of one.
     */
    public Model() {
        //stub :)
    }

    /**
     * checkShipAsteroidCollision -- checks for a Ship and Asteroid collision, updates Lives on collision.
     * @return void
     */
    public void checkShipAsteroidCollision(){
        //stub :)
    }

    /**
     * checkAsteroidBulletCollision -- checks for a Ship and Asteroid collision, removes both objects from lists on collision.
     * @return void
     */
    public void checkAsteroidBulletCollision(){
        // stub :)
    }

    /**
     * generateAsteroid -- creates a new Asteroid instance, and adds it to the current asteroidList.
     * @return void
     */
    public void generateAsteroid(){
        // add asteroid to list
    }

    /**
     * generateBullet -- creates a new Bullet instance, and adds it to the current bulletList.
     * @return void
     */
    public void generateBullet(){
        //stub :)
    }


    /**
     * createNewShip -- creates a new Spaceship instance in the event of destruction due to collision or game initialization.
     * @return void
     */
    public void createNewShip(){
        //stub :)
    }

    /**
     * moveShip -- changes Ship velocity on method call (will be called from Controller on keypress).
     * @return void
     */
    public void moveShip(){
        //stub :)
    }

    /**
     * getSpaceShip -- gets the current Spaceship instance in the model.
     * @return Spaceship current spaceship
     */
    public Spaceship getSpaceship(){
        return spaceship;
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
     * updateLives -- updates current lives based on other method triggers, e.g. collision.
     * @return void
     */
    public void updateLives(){
        //stub :)
    }

    /**
     * updateScore -- updates current Score based on method triggers (survival time, bullet Asteroid collision)
     * @return void
     */
    public void updateScore(){
        //stub :)
    }


}
