
package sample;


import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.*;




 /* Scoreboard.java
 * Scoreboard: Constructs a scoreboard for our game, including the current score and lives of the player.
 * Chet Aldrich and Josie Bealle
 */

public class Scoreboard extends Group implements ScoreboardInterface{

    private int score;
    private int lives;
    private Label scoreLabel;

    /**
     * Constructor
     */
    public Scoreboard(){
        this.score = 0;
        this.lives = 3;
        this.scoreLabel = new Label();
        this.scoreLabel.setText(String.format("Score: %d\nLives: %d", this.score, this.lives));
        this.scoreLabel.setLayoutX(0);
        this.scoreLabel.setLayoutY(720);
        this.scoreLabel.setTextFill(Color.LIGHTGREEN);
        this.getChildren().add(scoreLabel);
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

    public Label getScoreLabel(){ return this.scoreLabel; }


    public void setScoreLabel(Label scoreLabel){ this.scoreLabel = scoreLabel;}
}