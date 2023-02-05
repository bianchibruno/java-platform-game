package game;

import city.cs.engine.*;

public class Door extends StaticBody {
    private static final Shape shape = new BoxShape(1.4f, 2.5f);
    private static final BodyImage doorImage = new BodyImage("data/door.png",5f);

    public Door(World w) {
        super(w, shape);
        this.addImage(doorImage);
    }
}
