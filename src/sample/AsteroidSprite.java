package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by josiebealle on 17/11/14.
 */
public class AsteroidSprite extends Sprite {
    private Asteroid asteroid;

    public AsteroidSprite(){
        Image image = new Image(getClass().getResourceAsStream("/img/asteroid.png"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
    }
}
