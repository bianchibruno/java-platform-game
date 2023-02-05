package game;

import city.cs.engine.*;

public class Key extends DynamicBody implements SensorListener {
    private static final Shape keyShape = new PolygonShape(-0.816f, 0.184f, 0.776f, 0.16f, 0.772f, -0.252f, -0.812f, -0.232f);
    private static final BodyImage keyImage = new BodyImage("data/key.gif", 2f);

    public Key(World w) {
        super(w, keyShape);
        Sensor sensor = new Sensor(this, keyShape);

        GhostlyFixture ghostly = new GhostlyFixture(this, keyShape);

        sensor.addSensorListener(this);

        this.setGravityScale(0);

        this.addImage(keyImage);
    }


    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Player && e.getContactBody().getWorld() instanceof GameLevel) {
            ((Player) e.getContactBody()).setHasKey(true);
            this.destroy();
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
