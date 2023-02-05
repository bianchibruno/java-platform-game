package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SpellBook extends DynamicBody implements SensorListener {
    private static final Shape shape = new PolygonShape(-0.453f, 0.496f, 0.091f, 0.796f, 0.191f, 0.024f, -0.457f, -0.28f);
    private static final BodyImage image = new BodyImage("data/spellBook.gif", 2);

    public SpellBook(GameLevel world, float posX, float posY) {
        super(world, shape);
        Sensor sensor = new Sensor(this, shape);
        GhostlyFixture ghostly = new GhostlyFixture(this, shape);
        sensor.addSensorListener(this);
        this.setGravityScale(0);
        addImage(image);
        this.setPosition(new Vec2(posX, posY));
//        this.addCollisionListener(new Collisions(world.getPlayer()));
    }


    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Player) {
            ((Player) e.getContactBody()).increasePortalsLeft();
            this.destroy();
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
