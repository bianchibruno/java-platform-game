package game;

import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class Shooting extends MouseAdapter implements MouseListener {
    private WorldView view;
    private Player player;
    private GameLevel world;

    public Shooting(WorldView view, Player player, GameLevel world){
        this.view = view;
        this.player = player;
        this.world = world;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        if (world.getPlayer().getAmmoLeft() > 0 && (world instanceof Level2 || world instanceof Level3) && !Controller.isCreatingPortal()) {
            Bullet bullet = new Bullet(world);
            Vec2 vectorMouse = view.viewToWorld(new Point2D.Float(e.getX(), e.getY()));
            Vec2 dir = vectorMouse.sub(player.getPosition());
            dir = dir.mul(1 / (float) (Math.sqrt(dir.x * dir.x + dir.y * dir.y)));
            bullet.setPosition(new Vec2(player.getPosition().add(dir.mul(2))));
            bullet.setGravityScale(0);
            bullet.setLinearVelocity(dir.mul(40));
            world.getPlayer().decreaseAmmo();
        }

    }
}
