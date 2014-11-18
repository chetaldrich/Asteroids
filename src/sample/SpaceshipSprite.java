package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by josiebealle on 17/11/14.
 */
public class SpaceshipSprite extends Sprite{
    public SpaceshipSprite(){
        Image image = new Image(getClass().getResourceAsStream("/img/spaceship.png"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
    }
}
