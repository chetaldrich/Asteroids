
package sample.tests;

import org.junit.Test;

import static org.junit.Assert.*;
import sample.Scoreboard;

/**
 * ScoreboardTest.java
 * A suite of basic unit tests for the Scoreboard class.
 * Chet Aldrich and Josie Bealle
 */
public class ScoreboardTest {

    public ScoreboardTest() {

    }

    @Test
    public void testConstructor() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        assertTrue("Scoreboard Constructor Fail", (scoreboard instanceof Scoreboard));
    }

    @Test
    public void testGetScore() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setScore(4);
        assertTrue("Scoreboard getScore Fail", (4 == scoreboard.getScore()));
    }

    @Test
    public void testSetScore() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setScore(4);
        assertTrue("Scoreboard setScore Fail", (4 == scoreboard.getScore()));

    }

    @Test
    public void testGetLives() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setLives(3);
        assertTrue("Scoreboard getLives Fail", (3 == scoreboard.getLives()));

    }

    @Test
    public void testSetLives() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setLives(4);
        assertTrue("Scoreboard getLives Fail", (4 == scoreboard.getLives()));


    }
}