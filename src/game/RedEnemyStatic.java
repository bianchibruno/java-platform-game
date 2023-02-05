package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;

public class RedEnemyStatic extends Walker implements Collideable {
    private static ArrayList<RedEnemyStatic> redEnemyStaticArrayList = new ArrayList<>();
    private static BodyImage redEnemyRight = new BodyImage("data/RedEnemyRight.gif", 2.25f);
    private static BodyImage redEnemyLeft = new BodyImage("data/RedEnemyLeft.gif", 2.25f);
    private static BodyImage redEnemyRest = new BodyImage("data/RedEnemyRest.gif", 2.25f);
    private Shape shape0 = new PolygonShape(-0.924f, 1.101f, -0.942f, -1.131f, 0.75f, -1.131f, 0.75f, 1.119f);
    private Fixture fixture0 = new SolidFixture(this, shape0);
    private Shape shape1 = new PolygonShape(-0.954f, 0.741f, -1.506f, 0.087f, -0.942f, -0.381f);
    private Fixture spikeLeft = new SolidFixture(this, shape1);
    private Shape shape2 = new PolygonShape(0.75f, 0.945f, 1.512f, 0.081f, 0.774f, -0.537f);
    private Fixture spikeRight = new SolidFixture(this, shape2);

    public static BodyImage getRedEnemyRight() {
        return redEnemyRight;
    }

    public static ArrayList<RedEnemyStatic> getRedEnemyStaticArrayList() {
        return redEnemyStaticArrayList;
    }

    public static BodyImage getRedEnemyLeft() {
        return redEnemyLeft;
    }

    public static BodyImage getRedEnemyRest() {
        return redEnemyRest;
    }

    public RedEnemyStatic(GameLevel world, float posX, float posY) {
        super(world);
        addImage(redEnemyRest);
        this.setPosition(new Vec2(posX, posY));
        this.addCollisionListener(new Collisions(world.getPlayer()));
        redEnemyStaticArrayList.add(this);
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
