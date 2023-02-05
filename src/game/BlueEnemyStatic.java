package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;

public class BlueEnemyStatic extends Walker implements Collideable {
    private static ArrayList<BlueEnemyStatic> blueEnemyStaticArrayList = new ArrayList<>();
    private static BodyImage blueEnemyRight = new BodyImage("data/BlueEnemyRight.gif", 2.25f);
    private static BodyImage blueEnemyLeft = new BodyImage("data/BlueEnemyLeft.gif", 2.25f);
    private static BodyImage blueEnemyRest = new BodyImage("data/BlueEnemyRest.gif", 2.25f);
    private Shape shape0 = new PolygonShape(-0.904f, 0.374f, 0.891f, 0.378f, 0.896f, -1.125f, -0.904f, -1.125f);
    private Fixture fixture0 = new SolidFixture(this, shape0);
    private Shape shape1 = new PolygonShape(-0.895f, 0.374f, -0.004f, 1.116f, 0.896f, 0.374f);
    private Fixture spikeUp = new SolidFixture(this, shape1);

    public static ArrayList<BlueEnemyStatic> getBlueeEnemyStaticArrayList() {
        return blueEnemyStaticArrayList;
    }

    public static BodyImage getBlueEnemyRight() {
        return blueEnemyRight;
    }

    public static BodyImage getBlueEnemyLeft() {
        return blueEnemyLeft;
    }

    public static BodyImage getBlueEnemyRest() {
        return blueEnemyRest;
    }

    public BlueEnemyStatic(GameLevel world, float posX, float posY) {
        super(world);
        addImage(blueEnemyRight);
        this.setPosition(new Vec2(posX, posY));
        this.addCollisionListener(new Collisions(world.getPlayer()));
        blueEnemyStaticArrayList.add(this);
    }

    @Override
    public void collisionResponse(Body b) {
        if(b instanceof Player){
                ((Player) b).decreaseLifes();
        }
    }
    public void changeImage(BodyImage image){
        this.removeAllImages();
        this.addImage(image);

    }
}
