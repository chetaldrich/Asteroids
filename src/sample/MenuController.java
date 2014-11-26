package sample;


import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

/**
 * MenuController.java
 * Chet Aldrich and Josie Bealle
 * Implementation for changes between this menu and the asteroids game.
 */
public class MenuController implements Initializable{
    private static double screenWidth = 1200;
    private static double screenHeight = 800;
    private static Stage previousStage;
    private static Stage currentStage;


    /**
     * setPreviousStage -- sets the previous stage of the program for closing in subsequent windows.
     * @param stage stage that was previously focused
     */
    public static void setPreviousStage(Stage stage){
        previousStage = stage;
    }

    /**
     * setCurrentStage -- sets the current focused stage of the game for later closing.
     * @param stage the current focused stage
     */
    public static void setCurrentStage(Stage stage){
        currentStage = stage;
    }

    /**
     * initialize -- override basic method. Not required for the menu.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * gotoGame -- goes to and initializes the asteroids game.
     * @param actionEvent any registered mouse or keyboard event that triggers the button in fxml
     * @throws IOException
     */
    public void gotoGame(ActionEvent actionEvent) throws IOException {
        previousStage = currentStage;
        Stage stage = new Stage();
        stage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        final Parent root = (Parent)loader.load();
        Controller controller = loader.getController();

        root.setOnKeyPressed(controller);
        root.setOnMouseClicked(me -> root.requestFocus());

        root.setStyle("-fx-background-image: url('sample/img/spaceBackground.png')");
        stage.setTitle("#STELLAR");
        screenWidth = 1200;
        screenHeight = 800;
        stage.setScene(new Scene(root, screenWidth, screenHeight));
        Controller.setCurrentStage(stage);
        previousStage.close();
        stage.show();
        root.requestFocus();
    }

    /**
     * close -- exits the program.
     */
    public void close(){
        System.exit(1);

    }
}
