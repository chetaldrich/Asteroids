
package sample;


import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


 /** Scoreboard.java
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
        this.scoreLabel.setLayoutX(10);
        this.scoreLabel.setLayoutY(720);
        this.scoreLabel.setLineSpacing(10);
        this.scoreLabel.setFill(Color.LIGHTGREEN);
        this.getChildren().add(this.scoreLabel);


        //formatting for the controls in the game view.
        this.instructions=new Text();

        /*  Displayed as:
        Move: Arrow Keys or
                K               SPACE: fire bullet
        H               L
                J               M: toggle music
         */
        this.instructions.setText(String.format(
                "Move: Arrow Keys or\n" +
                        "\tK\t\tSPACE: fire bullet\n"+
                        "H\t\tL\n" +
                        "\tJ\t\tM: toggle music"));

        this.instructions.setFont(myFont);
        this.instructions.setLayoutX(720);
        this.instructions.setLayoutY(690);
        this.instructions.setLineSpacing(5);
        this.instructions.setFill(Color.LIGHTGREEN);

        this.getChildren().add(this.instructions);

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

    /**
     * setInstructions -- set the instructions for the game.
     * @param instructions the formatted Text object to send to the game view.
     */
    public void setInstructions(Text instructions){ this.instructions = instructions;}

    /**
     * getInstructions -- get the instructions for the game for use in the controller.
     * @return the formatted text object for presentation.
     */
    public Text getInstructions(){
        return this.instructions;
    }
}