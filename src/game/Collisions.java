package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.collision.Collision;

public class Collisions implements CollisionListener {
    private Player player;

    public Collisions(Player player){
        this.player = player;
    }
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Collideable){
            Collideable c = (Collideable) e.getReportingBody();

            c.collisionResponse(e.getOtherBody());
        }
    }
}
