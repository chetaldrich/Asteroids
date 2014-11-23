package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by josiebealle on 22/11/14.
 */
public class Explosion extends Sprite  {
    private Image image;
    private ImageView imageView;

    public Explosion(){
        //http://i826.photobucket.com/albums/zz186/willisnowell/Gifs/explosion_smoke_hg_clr.gif
        this.image = new Image(getClass().getResourceAsStream("/sample/img/kaboom.gif"), 100, 100, true, false );
        this.imageView = new ImageView();
        imageView.setImage(image);
        this.getChildren().add(imageView);
    }

    @Override
    public void makeSound(){


    }
}
