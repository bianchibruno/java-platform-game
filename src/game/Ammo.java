//package game;
//
//import city.cs.engine.*;
//import org.jbox2d.common.Vec2;
//
//import java.util.ArrayList;
//
//public class Ammo extends StaticBody implements Collideable {
//    private static final Shape shape = new CircleShape(0.5f);
//    private static BodyImage energyImage = new BodyImage("data/souls.png");
//    private static ArrayList<Ammo> ammoArrayList = new ArrayList<>();
//
//
//    public static ArrayList<Ammo> getAmmoArrayList() {
//        return ammoArrayList;
//    }
//
//    public Ammo(GameLevel world, float posX, float posY) {
//        super(world, shape);
//        addImage(energyImage);
//        ammoArrayList.add(this);
//        this.setPosition(new Vec2(posX, posY));
//        this.addCollisionListener(new Collisions(world.getPlayer()));
//    }
//
//    @Override
//    public void collisionResponse(Body b) {
//        if(b instanceof Player){
//            ((Player) b).increaseAmmo();
//            this.destroy();
//        }
//    }
//}


package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Ammo extends DynamicBody implements SensorListener {

    private static final Shape shape = new CircleShape(0.5f);
    private static BodyImage ammoImage = new BodyImage("data/souls.png");

    public Ammo(World w, float posX, float posY) {

        super(w);

        Sensor sensor = new Sensor(this, shape);

        GhostlyFixture ghostly = new GhostlyFixture(this, shape);

        sensor.addSensorListener(this);

        this.setGravityScale(0);

        addImage(ammoImage);

        this.setPosition(new Vec2(posX, posY));

    }

    @Override

    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Player) {
            this.destroy();
            ((Player) e.getContactBody()).increaseAmmo();
            e.getSensor().destroy();
        }

    }

    @Override

    public void endContact(SensorEvent sensorEvent) {

        System.out.println("End contact");

    }

}


