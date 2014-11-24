/**
 * BulletInterface.java
 * Bullet interface for the bullet class, which defines the bullets that our spaceship fires at asteroids
 * Methods include getBounds, makeSound, etc.
 * Chet Aldrich and Josie Bealle
 */

package sample;

import javafx.geometry.BoundingBox;


public interface BulletInterface {


    /**
     * step -- sets new position according to velocity
     */
    public void step();

    /**
     * makeSound -- make laser sound when bullets are fired from the ship.
     */
    public void makeSound();

    /**
     * getBounds -- generates a bounding box for the bullet, which is then used to determine collisions.
     * @return boundingbox for the bullet object
     */
    public BoundingBox getBounds();

}
