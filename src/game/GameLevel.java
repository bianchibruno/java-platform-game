package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {
    private Player player;

    public Player getPlayer(){
        return player;
    }

    public void populate(Game game) {
        player = new Player(this);
        player.setPosition(startPosition());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
        Key key = new Key(this);
        key.setPosition(keyPosition());
        key.addCollisionListener(new Collisions(player));

        for (int i = -15; i < 30; i++) {
            Grass grass = new Grass(this, i * 6, -4);
            GroundBlock groundBlock = new GroundBlock(this, i * 6, -8);
        }
    }

    public abstract Vec2 startPosition();
    public abstract Vec2 doorPosition();
    public abstract Vec2 keyPosition();
    public abstract boolean isCompleted();
    public abstract Image getBackgroundImage();


}
