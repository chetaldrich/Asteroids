package sample.tests;

import org.junit.Test;

import static org.junit.Assert.*;
import sample.*;

public class ModelTest {

    public ModelTest() {

    }

    @Test
    public void testCheckShipAsteroidCollision() throws Exception {
        Model model = new Model();
        Asteroid asteroid= new Asteroid();
        Spaceship spaceship = new Spaceship();

    }

    @Test
    public void testCheckAsteroidBulletCollision() throws Exception {
        Model model = new Model();
        Asteroid asteroid= new Asteroid();
        Bullet bullet = new Bullet();
    }

}