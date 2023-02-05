package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.pooling.IWorldPool;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Level1 extends GameLevel {
    private Player player;
    private Image background;


    @Override
    public void populate(Game game){
        super.populate(game);
        player = super.getPlayer();
        background = new ImageIcon("data/background1.jpg").getImage();

        RedEnemyStatic redEnemyStatic = new RedEnemyStatic(this, 15, -2);
        Ammo ammo1 = new Ammo(this, 5, 5);
        SpellBook book = new SpellBook(this, 5, 8);

    }



    @Override
    public Vec2 startPosition() {
        return new Vec2(2, 1);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(40f, -0.5f);
    }

    @Override
    public Vec2 keyPosition() {
        return new Vec2(20, 5);
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
