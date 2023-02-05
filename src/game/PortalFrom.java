package game;

import city.cs.engine.*;

public class PortalFrom extends StaticBody {
    private static final Shape shape = new BoxShape(0.1f, 2.25f);
    private static BodyImage image = new BodyImage("data/portal.gif", 4.5f);

    public PortalFrom(World world) {
        super(world, shape);
        addImage(image);
    }
}
