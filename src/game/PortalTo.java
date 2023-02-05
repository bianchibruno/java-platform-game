package game;

import city.cs.engine.*;

public class PortalTo extends StaticBody {
    private GameLevel world;
    private static final Shape shape = new BoxShape(0.1f, 2.25f);
    private static BodyImage image = new BodyImage("data/portalTo.gif", 4.5f);

    public PortalTo(GameLevel world) {
        super(world, shape);
        addImage(image);
    }

}
