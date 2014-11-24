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
     *
     * @return int current score
     */
    public int getScore();

    /**
     * setScore -- sets score of the player in the game.
     *
     * @param score the score to set to
     */
    public void setScore(int score);

    /**
     * getLives -- gets the current number of lives for the player in the game.
     *
     * @return int number of lives
     */
    public int getLives();

    /**
     * setLives -- sets number of lives for the player in the game.
     *
     * @param lives the number of lives to set to
     */
    public void setLives(int lives);

    /**
     * getScoreLabel -- returns the label that provides scores and lives on the view.
     *
     * @return Text the formatted result of the text generated in the constructor
     */
    public Text getScoreLabel();

    /**
     * setScoreLabel -- sets the label in this class to one assigned.
     *
     * @param scoreLabel the intended result scoreLabel
     */
    public void setScoreLabel(Text scoreLabel);

    /**
     * setInstructions -- set the instructions for the game.
     *
     * @param instructions the formatted Text object to send to the game view.
     */
    public void setInstructions(Text instructions);

    /**
     * getInstructions -- get the instructions for the game for use in the controller.
     *
     * @return the formatted text object for presentation.
     */
    public Text getInstructions();

}
