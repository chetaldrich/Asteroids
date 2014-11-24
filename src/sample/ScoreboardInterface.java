/**
 * ScoreboardInterface.java
 * ScoreboardInterface: Provides an interface for Scoreboard, which constructs a scoreboard for our game.
 * Includes the current score and lives of the player.
 * Chet Aldrich and Josie Bealle
 */
package sample;

import javafx.scene.text.Text;


public interface ScoreboardInterface {

    /**
     * getScore -- gets score of the player in the game.
     * @return int current score
     */
    public int getScore();

    /**
     * setScore -- sets score of the player in the game.
     * @param score the score to set to
     */
    public void setScore(int score);

    /**
     * getLives -- gets the current number of lives for the player in the game.
     * @return int number of lives
     */
    public int getLives();

    /**
     * setLives -- sets number of lives for the player in the game.
     * @param lives the number of lives to set to
     */
    public void setLives(int lives);

    public Text getScoreLabel();

    public void setScoreLabel(Text scoreLabel);
}
