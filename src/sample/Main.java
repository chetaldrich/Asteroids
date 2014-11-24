/**
 * Main.java
 * Main class of our program, which launches the game and associated classes.
 * Chet Aldrich and Josie Bealle
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


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
        controller.setCurrentStage(primaryStage);

        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();

    }








    public static void main(String[] args) {
        launch(args);
    }
}

