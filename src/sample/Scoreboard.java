package sample;

//import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Formatter;
import java.util.Locale;


/**
 * Scoreboard: Constructs a scoreboard for our game, including the current score and lives of the player.
 */
public class Scoreboard extends Group implements ScoreboardInterface{

    private int score;
    private int lives;
    private Text text;
    private StringBuilder sb;
    private Formatter formatter;

    /**
     * Constructor
     */
    public Scoreboard(){
        this.score = 0;
        this.lives = 3;
        Paint fill = Color.LIGHTPINK;
        Rectangle displayRect = new Rectangle(0, 700, 1200,100);
        displayRect.setFill(fill);
        sb = new StringBuilder();
        formatter = new Formatter(sb, Locale.US);
        formatter.format("Score: %d\nLives: %d", this.score, this.lives);
        String scoreString = sb.toString();
        text = new Text(0, 720, scoreString);
        this.getChildren().add(displayRect);
        this.getChildren().add(text);
    }

    public void updateText(){
        this.getChildren().remove(text);
        sb = new StringBuilder();
        formatter = new Formatter(sb, Locale.US);
        formatter.format("Score: %d\nLives: %d", this.score, this.lives);
        String scoreString = sb.toString();
        text = new Text(scoreString);
        this.getChildren().add(text);
    }

    /**
     * getScore -- gets score of the player in the game.
     * @return int current score
     */
    public int getScore(){
        return this.score;
    }

    /**
     * setScore -- sets score of the player in the game.
     * @param score the score to set to
     */
    public void setScore(int score){
        this.score = score;
    }

    /**
     * getLives -- gets the current number of lives for the player in the game.
     * @return int number of lives
     */
    public int getLives(){
       return this.lives;
    }

    /**
     * setLives -- sets number of lives for the player in the game.
     * @param lives the number of lives to set to
     */
    public void setLives(int lives){
        this.lives = lives;
    }
}