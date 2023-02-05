package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GroundBlock extends StaticBody{

    private static final Shape groundBlockShape = new PolygonShape(-3.01f,2.95f, -3.0f,-3.0f, 2.98f,-3.0f, 2.99f,3.0f);
    private static final BodyImage groundBlockImage = new BodyImage("data/groundblock2.png", 6f);

    public GroundBlock(World world, float posX, float posY) {
        super(world, groundBlockShape);
        addImage(groundBlockImage);
        this.setPosition(new Vec2(posX, posY));
    }



}
