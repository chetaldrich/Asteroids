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
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main extends Application {
    public static double screenWidth;
    public static double screenHeight;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Asteroids Menu");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));

        Pane myPane = (Pane) loader.load();

        MenuController controller = (MenuController) loader.getController();

        controller.setPreviousStage(primaryStage);

        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();

    }

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        stage = primaryStage;
//        stage.setOnCloseRequest(t -> {
//            Platform.exit();
//            System.exit(0);
//        });
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
//        final Parent root = (Parent)loader.load();
//        Controller controller = loader.getController();
//
//        root.setOnKeyPressed(controller);
//        root.setOnMouseClicked(me -> root.requestFocus());
//
//        root.setStyle("-fx-background-image: url('sample/img/spaceBackground.png')");
//        stage.setTitle("#STELLAR");
//        this.screenWidth = 1200;
//        this.screenHeight = 800;
//        stage.setScene(new Scene(root, screenWidth, screenHeight));
//        stage.show();
//        root.requestFocus();
//
//    }







    public static void main(String[] args) {
        launch(args);
    }
}

