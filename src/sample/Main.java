/**
 * Main.java
 * Main class of our program, which launches the game and associated classes.
 * Chet Aldrich and Josie Bealle
 */

package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main extends Application {
    public double screenWidth;
    public double screenHeight;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
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
        stage.show();
        root.requestFocus();

    }

    public void goToGameOver(){
        try {
            replaceSceneContent("login.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 700, 450);
            scene.getStylesheets().add(Main.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }




    public static void main(String[] args) {
        launch(args);
    }
}

