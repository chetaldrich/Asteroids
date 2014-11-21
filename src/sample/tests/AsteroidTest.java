/**
 * AsteroidTest.java
 * A suite of basic unit tests for the Asteroid class.
 * Chet Aldrich and Josie Bealle
 */

package sample.tests;
import javafx.geometry.Point2D;
import sample.Asteroid;

import static org.junit.Assert.*;


import org.junit.Test;


public class AsteroidTest {

    public AsteroidTest() {

    }



    @Test
    public void testGetPosition() throws Exception {
        Asteroid asteroid = new Asteroid();
        asteroid.setPosition(2,2);
        assertEquals("Asteroid getPosition Fail", new Point2D(2,2), asteroid.getPosition());

    }

    @Test
    public void testSetPosition() throws Exception {
        Asteroid asteroid = new Asteroid();
        asteroid.setPosition(4,4);
        assertEquals("Asteroid setPosition Fail", new Point2D(4,4), asteroid.getPosition());

    }

    /*@Test
    public void testVanish() throws Exception {
        Asteroid asteroid = new Asteroid(500, 500);
        asteroid.vanish();
        assertNull("Asteroid vanish Fail", asteroid);

    }*/

    @Test
    public void testGetVelocity() throws Exception {
        Asteroid asteroid = new Asteroid();
        asteroid.setVelocity(2, 2);
        assertEquals("Asteroid getVelocity Fail", new Point2D(2,2), asteroid.getVelocity());

    }

    @Test
    public void testSetVelocity() throws Exception {
        Asteroid asteroid = new Asteroid();
        asteroid.setVelocity(4, 4);
        assertEquals("Asteroid setVelocity Fail", new Point2D(4,4), asteroid.getVelocity());

    }

    @Test
    public void testStep() throws Exception {
        Asteroid asteroid = new Asteroid();
        Point2D oldPosition = asteroid.getPosition();
        double xPosition = oldPosition.getX();
        double yPosition = oldPosition.getY();

        asteroid.setVelocity(2,2);
        Point2D asteroidVelocity = asteroid.getVelocity();
        double xVelocity = asteroidVelocity.getX();
        double yVelocity = asteroidVelocity.getY();

        Point2D newPosition = new Point2D(xPosition + xVelocity, yPosition + yVelocity);

        asteroid.step();
        assertEquals("Asteroid step Fail", newPosition, asteroid.getPosition());

    }
}