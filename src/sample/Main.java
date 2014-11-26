

package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Main.java
 * Main class of our program, which launches the game and associated classes.
 * Josie Bealle and Chet Aldrich
 */
public class Main extends Application {

    @Override
    /**
     * This starts up our menu page where the user can either play or quit!
     * but why would they every quit
     */
    public void start(Stage primaryStage) throws Exception{
        MenuController.setPreviousStage(primaryStage);
        MenuController.setCurrentStage(primaryStage);
        primaryStage.setTitle("Asteroids Menu");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Pane myPane = loader.load();
        MenuController controller = loader.getController();
        myPane.setStyle("-fx-background-image: url('sample/img/asteroidsmenu.png')");
        controller.setCurrentStage(primaryStage);
        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();

    }


    /**
     * what do you think it does silly
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

