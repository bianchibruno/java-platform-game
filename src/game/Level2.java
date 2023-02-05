package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Level2 extends GameLevel {
    private Player player;
    private Image background;

    @Override
    public void populate(Game game){
        super.populate(game);
        player = super.getPlayer();
        background = new ImageIcon("data/background2.jpg").getImage();

        Ground ground1 = new Ground(this, 0, 3);
        Ground ground2 = new Ground(this, 10, 12);
        Ground ground3 = new Ground(this, -5, 20);
        Ground ground4 = new Ground(this, 12, 27);


        BlueEnemyMoving blueEnemyMoving = new BlueEnemyMoving(this, 20, -0.5f);
        BlueEnemyStatic blueEnemyStatic = new BlueEnemyStatic(this, -5, 21);

    }
    @Override
    public Vec2 startPosition() {
        return new Vec2(2, 1);
    }
    @Override
    public Vec2 doorPosition() {
        return new Vec2(25f, -0.5f);
    }

    @Override
    public Vec2 keyPosition() {
        return new Vec2(12, 30);
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
