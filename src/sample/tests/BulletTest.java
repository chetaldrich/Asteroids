package sample.tests;


import javafx.geometry.Point2D;
import org.junit.Test;

import sample.Bullet;
import sample.Spaceship;


import static org.junit.Assert.*;


public class BulletTest {
    public BulletTest() {

    }




    @Test
    public void testGetPosition() throws Exception {
        Bullet bullet = new Bullet();
        bullet.setPosition(2,2);
        assertEquals("Bullet getPosition Fail", new Point2D(2,2), bullet.getPosition());
    }

    @Test
    public void testSetPosition() throws Exception {
        Bullet bullet = new Bullet();
        bullet.setPosition(4,4);
        assertEquals("Bullet setPosition Fail", new Point2D(4,4), bullet.getPosition());
    }

   

    @Test
    public void testGetVelocity() throws Exception {
        Bullet bullet = new Bullet();
        bullet.setVelocity(2,2);
        assertEquals("Bullet getVelocity Fail", new Point2D(2,2), bullet.getVelocity());
    }

    @Test
    public void testSetVelocity() throws Exception {
        Bullet bullet = new Bullet();
        bullet.setVelocity(4,4);
        assertEquals("Bullet setVelocity Fail", new Point2D(4,4), bullet.getVelocity());

    }

    @Test
    public void testStep() throws Exception {
        Bullet bullet = new Bullet();
        Point2D oldPosition = bullet.getPosition();
        double xPosition = oldPosition.getX();
        double yPosition = oldPosition.getY();

        bullet.setVelocity(2,2);
        Point2D bulletVelocity = bullet.getVelocity();
        double xVelocity = bulletVelocity.getX();
        double yVelocity = bulletVelocity.getY();

        Point2D newPosition = new Point2D(xPosition + xVelocity, yPosition + yVelocity);

        bullet.step();
        assertEquals("Bullet step Fail", newPosition, bullet.getPosition());

    }
}