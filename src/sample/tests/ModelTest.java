
package sample.tests;

import javafx.geometry.Point2D;
import org.junit.Test;

import static org.junit.Assert.*;
import sample.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ModelTest.java
 * A suite of tests for the Model class.
 * Chet Aldrich and Josie Bealle
 */
public class ModelTest {

    public ModelTest() {

    }

    @Test
    public void testCheckShipAsteroidCollision() throws Exception {
        Model model = new Model(500,500);
        model.generateAsteroid();
        model.createNewShip();
        Spaceship spaceship = model.getSpaceship();
        List asteroids = model.getAsteroidList();
        Asteroid asteroid = (Asteroid) asteroids.get(0);
        Point2D spaceshipLocation = spaceship.getPosition();
        double spaceshipLocationX = spaceshipLocation.getX();
        double spaceshipLocationY = spaceshipLocation.getY();

        asteroid.setPosition(spaceshipLocationX, spaceshipLocationY);


        //builds the expected result of method run
        ArrayList<Sprite> expected = new ArrayList<Sprite>();
        expected.add(spaceship);
        expected.add(asteroid);

        assertEquals(expected, model.checkGameCollisions("spaceship-asteroid", spaceship));

    }


    @Test
    public void testCheckAsteroidBulletCollision() throws Exception {
        Model model = new Model(500,500);
        model.generateAsteroid();
        model.generateBullet();
        List<Bullet> bullets = model.getBulletList();
        List<Asteroid> asteroids = model.getAsteroidList();
        Asteroid asteroid = asteroids.get(0);
        Bullet bullet = bullets.get(0);
        Point2D firstBulletLocation = bullets.get(0).getPosition();
        double firstBulletLocationX = firstBulletLocation.getX();
        double firstBulletLocationY = firstBulletLocation.getY();

        asteroids.get(0).setPosition(firstBulletLocationX, firstBulletLocationY);

        ArrayList<Sprite> expected = new ArrayList<Sprite>();
        expected.add(bullet);
        expected.add(asteroid);

        assertEquals(expected, model.checkGameCollisions("bullet-asteroid", new Spaceship()));

    }

    @Test
    public void testCollided() throws Exception {
        Model model = new Model(500,500);
        model.generateAsteroid();
        model.generateBullet();
        List<Bullet> bullets = model.getBulletList();
        List<Asteroid> asteroids = model.getAsteroidList();
        Asteroid asteroid = asteroids.get(0);
        Bullet bullet = bullets.get(0);
        Point2D firstBulletLocation = bullets.get(0).getPosition();
        double firstBulletLocationX = firstBulletLocation.getX();
        double firstBulletLocationY = firstBulletLocation.getY();

        asteroid.setPosition(firstBulletLocationX, firstBulletLocationY);

        assertTrue(model.collided(asteroid, bullet));

    }

    @Test
    public void testGenerateAsteroid(){
        Model model = new Model(500,500);
        Asteroid testAsteroid = model.generateAsteroid();
        assertTrue("Model generateAsteroid() Fail", 1==model.getAsteroidList().size());
        assertNotNull("Model generateAsteroid() return Fail", model.generateAsteroid());
    }

    @Test
    public void testGenerateBullet(){
        Model model = new Model(500,500);
        Bullet testBullet = model.generateBullet();
        assertTrue("Model generateBullet() Fail", 1==model.getBulletList().size());
        assertNotNull("Model generateBullet() return Fail", model.generateBullet());

    }

    @Test
    public void testCreateNewShip(){
        Model model = new Model(500,500);
        model.createNewShip();
        assertNotNull("Model createNewShip() Fail", model.getSpaceship());
    }


    @Test
    public void testUpdateLives(){
        Model model = new Model(500,500);
        model.createScoreboard();
        Scoreboard scoreboard = model.getScoreboard();
        int oldLives = scoreboard.getLives();
        model.updateLives(1);
        assertTrue("Model updateLives Fail", (scoreboard.getLives()==oldLives+1));


    }

    @Test
    public void testUpdateScore(){
        Model model = new Model(500,500);
        model.createScoreboard();
        Scoreboard scoreboard = model.getScoreboard();
        int oldScore = scoreboard.getScore();
        model.updateScore(3);
        assertTrue("Model updateScore Fail", (scoreboard.getScore()==oldScore+3));

    }

}