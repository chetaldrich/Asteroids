package sample;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * Created by josiebealle on 17/11/14.
 */
public class BulletSprite extends Sprite{

    public BulletSprite(){
        Paint fill = Color.GRAY;
        Circle bullet = new Circle(0, 0, 2.0,  fill);
        this.getChildren().add(bullet);
    }
}
