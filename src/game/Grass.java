package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Grass extends StaticBody{

    private static final Shape grassShape = new BoxShape(3, 1);
    private static final BodyImage grassImage = new BodyImage("data/grass.png", 2f);

    public Grass(World world, float posX, float posY) {
        super(world, grassShape);
        addImage(grassImage);
        this.setPosition(new Vec2(posX, posY));
    }



}
