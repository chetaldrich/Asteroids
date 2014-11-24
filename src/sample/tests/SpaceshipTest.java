package sample.tests;

import javafx.geometry.Point2D;
import org.junit.Test;

import sample.Spaceship;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * SpaceshipTest.java
 * A suite of basic unit tests for the Spaceship class.
 * Chet Aldrich and Josie Bealle
 */
public class SpaceshipTest {
    public SpaceshipTest() {

    }



    @Test
    public void testGetPosition() throws Exception {
        Spaceship spaceship = new Spaceship();
        spaceship.setPosition(2,2);
        assertEquals("Spaceship getPosition Fail", new Point2D(2,2), spaceship.getPosition());

    }

    @Test
    public void testSetPosition() throws Exception {
        Spaceship spaceship = new Spaceship();
        spaceship.setPosition(4,4);
        assertEquals("Spaceship setPosition Fail", new Point2D(4,4), spaceship.getPosition());

    }

    @Test
    public void testGetVelocity() throws Exception {
        Spaceship spaceship = new Spaceship();
        spaceship.setVelocity(2,2);
        assertEquals("Spaceship getVelocity Fail", new Point2D(2,2), spaceship.getVelocity());

    }

    @Test
    public void testSetVelocity() throws Exception {
        Spaceship spaceship = new Spaceship();
        spaceship.setVelocity(4,4);
        assertEquals("Spaceship setVelocity Fail", new Point2D(4,4), spaceship.getVelocity());

    }

    @Test
    public void testStep() throws Exception {
        Spaceship spaceship = new Spaceship();

        Point2D oldPosition = spaceship.getPosition();
        double xPosition = oldPosition.getX();
        double yPosition = oldPosition.getY();

        spaceship.setPosition(202, 402);

        Point2D newPosition = new Point2D(202, 402);

        spaceship.step();
        assertEquals("Spaceship step Fail", newPosition, spaceship.getPosition());

    }

}