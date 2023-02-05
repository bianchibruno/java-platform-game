package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Ground extends StaticBody {

    private static final Shape groundShape = new BoxShape(3, 1);
    private static final BodyImage groundImage = new BodyImage("data/ground.png", 2f);

    public static Shape getGroundShape() {
        return groundShape;
    }

    public static BodyImage getGroundImage() {
        return groundImage;
    }

    public Ground(World world, float posX, float posY) {
        super(world, groundShape);
        addImage(groundImage);
        this.setPosition(new Vec2(posX, posY));
    }

}
