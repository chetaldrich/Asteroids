package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {
    public double screenWidth;
    public double screenHeight;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = (Parent)loader.load();
        Controller controller = loader.getController();
       
        // Here, call whatever methods you want to call on controller.
        root.setOnKeyPressed(controller);

        root.setStyle("-fx-background-image: url('sample/img/spaceBackground.png')");
        primaryStage.setTitle("#STELLAR");
        this.screenWidth = 1200;
        this.screenHeight = 800;
        primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }
}

