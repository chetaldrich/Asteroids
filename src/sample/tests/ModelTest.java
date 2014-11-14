package sample.tests;

import javafx.geometry.Point2D;
import org.junit.Test;

import static org.junit.Assert.*;
import sample.*;

import java.util.List;

public class ModelTest {

    public ModelTest() {

    }

    @Test
    public void testCheckShipAsteroidCollision() throws Exception {
        Model model = new Model();
        model.generateAsteroid();
        model.createNewShip();
        Spaceship spaceship = model.getSpaceship();
        List<Asteroid> asteroids = model.getAsteroidList();
        Point2D spaceshipLocation = spaceship.getPosition();
        double spaceshipLocationX = spaceshipLocation.getX();
        double spaceshipLocationY = spaceshipLocation.getY();

        asteroids.get(0).setPosition(spaceshipLocationX, spaceshipLocationY);

        assertTrue("Model checkShipAsteroidCollision() Fail", model.checkShipAsteroidCollision());

    }

    @Test
    public void testCheckAsteroidBulletCollision() throws Exception {
        Model model = new Model();
        model.generateAsteroid();
        model.generateBullet();
        List<Bullet> bullets = model.getBullets();
        List<Asteroid> asteroids = model.getAsteroidList();
        Point2D firstBulletLocation = bullets.get(0).getPosition();
        double firstBulletLocationX = firstBulletLocation.getX();
        double firstBulletLocationY = firstBulletLocation.getY();

        asteroids.get(0).setPosition(firstBulletLocationX, firstBulletLocationY);

        assertTrue("Model checkAsteroidBulletCollision() Fail", model.checkAsteroidBulletCollision());

    }

    @Test
    public void testGenerateAsteroid(){
        Model model = new Model();
        model.generateAsteroid();
        assertTrue("Model generateAsteroid() Fail", 1==model.getAsteroidList().size());
    }

    @Test
    public void testGenerateBullet(){
        Model model = new Model();
        model.generateBullet();
        assertTrue("Model generateBullet() Fail", 1==model.getBulletList().size());

    }

    @Test
    public void testCreateNewShip(){
        Model model = new Model();
        model.createNewShip();
        assertNotNull("Model createNewShip() Fail", model.getSpaceship());
    }

    @Test
    public void testMoveShip(){
        Model model = new Model();
        model.createNewShip();
        Spaceship spaceship = model.getSpaceship();
        Point2D spaceshipLocation = spaceship.getPosition();
        double spaceshipLocationX = spaceshipLocation.getX();
        double spaceshipLocationY = spaceshipLocation.getY();
        model.moveShip();
        Point2D spaceshipLocationNew = spaceship.getPosition();
        double spaceshipLocationXNew = spaceshipLocation.getX();
        double spaceshipLocationYNew = spaceshipLocation.getY();

        assertFalse("Model moveShip() Fail", (spaceshipLocationY==spaceshipLocationYNew));


    }

    @Test
    public void testUpdateLives(){
        Model model = new Model();
        model.createScoreboard();
        Scoreboard scoreboard = model.getScoreboard();

        model.updateLives(2);
        assertTrue("Model updateLives Fail", (scoreboard.getLives()==2));


    }

    @Test
    public void testUpdateScore(){
        Model model = new Model();
        model.createScoreboard();
        Scoreboard scoreboard = model.getScoreboard();

        model.updateScore(3);
        assertTrue("Model updateScore Fail", (scoreboard.getScore()==3));

    }

}