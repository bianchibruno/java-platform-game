package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;

public class BlueEnemyMoving extends Walker implements Collideable {
    private static float speed = -15;
    private static ArrayList<BlueEnemyMoving> blueEnemyMovingArrayList = new ArrayList<>();
    private static BodyImage blueEnemyRight = new BodyImage("data/BlueEnemyRight.gif",2.25f);
    private static BodyImage blueEnemyLeft = new BodyImage("data/BlueEnemyLeft.gif",2.25f);
    private static BodyImage blueEnemyRest = new BodyImage("data/BlueEnemyRest.gif",2.25f);
    private Shape shape0 = new PolygonShape(-0.904f,0.374f, 0.891f,0.378f, 0.896f,-1.125f, -0.904f,-1.125f);
    private Fixture fixture0 = new SolidFixture(this, shape0);
    private Shape shape1 = new PolygonShape(-0.895f,0.374f, -0.004f,1.116f, 0.896f,0.374f);
    private Fixture spikeUp = new SolidFixture(this, shape1);

    public static BodyImage getBlueEnemyRight() {
        return blueEnemyRight;
    }

    public static BodyImage getBlueEnemyLeft() {
        return blueEnemyLeft;
    }

    public static BodyImage getBlueEnemyRest() {
        return blueEnemyRest;
    }

    public static ArrayList<BlueEnemyMoving> getBlueEnemyMovingArrayList() {
        return blueEnemyMovingArrayList;
    }

    public BlueEnemyMoving(GameLevel world, float posX, float posY) {
        super(world);
        addImage(blueEnemyRight);
        blueEnemyMovingArrayList.add(this);
        if(this.getWorld() instanceof Level2)
            this.startWalking((float) ((Math.random()+0.5) * speed));
        else
            this.startWalking(speed);
        this.setPosition(new Vec2(posX, posY));
        this.addCollisionListener(new Collisions(world.getPlayer()));
    }
    public void changeImage(BodyImage image){

        this.removeAllImages();
        this.addImage(image);
    }

    @Override
    public void collisionResponse(Body b) {
        if (b instanceof Player) {
            ((Player) b).decreaseLifes();
        }
    }
}
