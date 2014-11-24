
package sample;


import javafx.fxml.FXML;
import javafx.scene.Group;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;




 /* Scoreboard.java
 * Scoreboard: Constructs a scoreboard for our game, including the current score and lives of the player.
 * Chet Aldrich and Josie Bealle
 */

public class Scoreboard extends Group implements ScoreboardInterface{

    private int score;
    private int lives;
    private Text scoreLabel;
    private Text instructions;




    /**
     * Constructor
     */
    public Scoreboard(){
        this.score = 0;
        this.lives = 3;

        //formatting for the score and lives in the game view.
        this.scoreLabel=new Text();
        this.scoreLabel.setText(String.format("Score: %d\nLives: %d", this.score, this.lives));
        Font myFont = new Font("Lucida Console", 18);
        this.scoreLabel.setFont(myFont);
        this.scoreLabel.setLayoutX(0);
        this.scoreLabel.setLayoutY(720);
        this.scoreLabel.setLineSpacing(5);
        this.scoreLabel.setFill(Color.LIGHTGREEN);
        this.getChildren().add(scoreLabel);

        //formatting for the controls in the game view.
        this.instructions=new Text();
        this.instructions.setText(String.format("Controls:\n" +
                "Arrow Keys and" +
                "\t\tK" +
               "\t\t\tSPACE: fire bullet" +
                "\nH\t\tL\n\tJ" +
                "\t\t\t\\t\\t\\tSPACE: fire bullet"));
        this.instructions.setFont(myFont);
        this.instructions.setLayoutX(800);
        this.instructions.setLayoutY(650);
        this.instructions.setLineSpacing(5);
        this.instructions.setFill(Color.LIGHTGREEN);

        
        this.getChildren().add(instructions);
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
     * @param lives the desired number of lives
     */
    public void setLives(int lives){
        this.lives = lives;
    }

    /**
     * getScoreLabel -- returns the label that provides scores and lives on the view.
     * @return Text the formatted result of the text generated in the constructor
     */
    public Text getScoreLabel(){ return this.scoreLabel; }

    /**
     * setScoreLabel -- sets the label in this class to one assigned.
     * @param scoreLabel the intended result scoreLabel
     */
    public void setScoreLabel(Text scoreLabel){ this.scoreLabel = scoreLabel;}
}