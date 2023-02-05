package game;

import city.cs.engine.*;

public class Bullet extends DynamicBody implements Collideable {
    private static final float radius = 0.5f;
    private static final Shape PlasmaBallShape = new CircleShape(radius);
    private static final BodyImage PlasmaBallImage =
            new BodyImage("data/plasma.png", 2 * radius);
    private static final int maxRebounds = 2;
    private static final int rebounds = 0;


    public Bullet(GameLevel world) {
        super(world);
        SolidFixture f = new SolidFixture(this, PlasmaBallShape);
        f.setRestitution(1);
        addImage(PlasmaBallImage);
        this.addCollisionListener(new Collisions(world.getPlayer()));
    }

    @Override
    public void collisionResponse(Body b) {
        if (b instanceof RedEnemyMoving || b instanceof RedEnemyStatic || b instanceof BlueEnemyMoving || b instanceof BlueEnemyStatic) {
            b.destroy();
        } else if (b instanceof Player) {
            this.destroy();
            ((Player) b).increaseAmmo();
        }
    }
}
