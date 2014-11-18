package sample;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import sample.*;

public class Controller {
    //public Group spaceGroup;
    private Model spaceModel;
    private double screenWidth;
    private double screenHeight;
    private Spaceship spaceship;

    public Controller(){

    }

    /**
     * Initializes game elements
     */
    public void initialize() {
        this.screenHeight = 800;
        this.screenWidth = 1200;
        //this.spaceModel = new Model(this.screenWidth, this.screenHeight);
        //spaceModel.createNewShip();




    }



}
