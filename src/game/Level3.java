package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Level3 extends GameLevel {
    private Player player;
    private Image background;

    @Override
    public void populate(Game game) {
        super.populate(game);
        player = super.getPlayer();
        background = new ImageIcon("data/background3.jpg").getImage();

        PortalTo portalTo1 = new PortalTo(this);
        portalTo1.setPosition(new Vec2(-25, 15));
        PortalFrom portalFrom1 = new PortalFrom(this);
        portalFrom1.setPosition(new Vec2(30, 0));

        PortalFrom portalFrom2 = new PortalFrom(this);
        portalFrom2.setPosition(new Vec2(30, 15));
        PortalTo portalTo2 = new PortalTo(this);
        portalTo2.setPosition(new Vec2(-25, 30));

        PortalFrom portalFrom3 = new PortalFrom(this);
        portalFrom3.setPosition(new Vec2(10, 30));
        PortalTo portalTo3 = new PortalTo(this);
        portalTo3.setPosition(new Vec2(-15, 1));

        RedEnemyStatic redEnemyStatic = new RedEnemyStatic(this, 10, 0);
        RedEnemyStatic redEnemyStatic1 = new RedEnemyStatic(this, 5, 0);
        RedEnemyStatic redEnemyStatic2 = new RedEnemyStatic(this, 15, 0);

        RedEnemyMoving redEnemyMoving = new RedEnemyMoving(this, 10, 15);
        RedEnemyMoving redEnemyMoving2 = new RedEnemyMoving(this, 10, 15);

        BlueEnemyStatic blueEnemyStatic = new BlueEnemyStatic(this, 5, 30);
        BlueEnemyMoving blueEnemyMoving = new BlueEnemyMoving(this, 20, 30);

        for (int i = -15; i < 30; i++) {
            Grass grass = new Grass(this, i * 6, 11);
            GroundBlock groundBlock = new GroundBlock(this, i * 6, 7);
        }

        for (int i = -15; i < 30; i++) {
            Grass grass = new Grass(this, i * 6, 26);
            GroundBlock groundBlock = new GroundBlock(this, i * 6, 22);
        }

        for (Body body : this.getDynamicBodies()) {
            body.addCollisionListener(new PortalListener(portalFrom1, portalTo1));
            body.addCollisionListener(new PortalListener(portalFrom2, portalTo2));
            body.addCollisionListener(new PortalListener(portalFrom3, portalTo3));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(0, 0);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, 1f);
    }

    @Override
    public Vec2 keyPosition() {
        return new Vec2(0, 30);
    }

    @Override
    public boolean isCompleted() {
        return this.getPlayer().HasKey();
    }

    @Override
    public Image getBackgroundImage() {
        return background;
    }
}
