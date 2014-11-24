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
 * implementation for changes between this menu and the asteroids game.
 */
public class MenuController implements Initializable{
    private static double screenWidth = 1200;
    private static double screenHeight = 800;
    private Stage previousStage;
    private Stage currentStage;



    public void setPreviousStage(Stage stage){
        this.previousStage = stage;
    }

    public void setCurrentStage(Stage stage){
        this.currentStage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void gotoGame(ActionEvent actionEvent) throws IOException {
        Controller.setPreviousStage(new Stage());
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
        this.screenWidth = 1200;
        this.screenHeight = 800;
        stage.setScene(new Scene(root, screenWidth, screenHeight));
        previousStage.close();
        stage.show();
        root.requestFocus();
    }

    public void close(){
        currentStage.close();
    }
}
