package game;

import city.cs.engine.WorldView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Dummy mouse listener.
 */
public class CreatingPortal implements MouseListener {
    private PortalTo portalTo;
    private PortalFrom portalFrom;
    private WorldView view;
    private Player player;
    private GameLevel world;
    private boolean fromCreated;


    public CreatingPortal(GameLevel world, Player player, WorldView view) {
        this.world = world;
        this.player = player;
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Controller.isCreatingPortal() && portalFrom != null) {
            portalTo = new PortalTo(world);
            portalTo.setPosition(view.viewToWorld(e.getPoint()));
            fromCreated = false;
            player.decreasePortalsLeft();
            player.addCollisionListener(new PortalListener(portalFrom, portalTo));
            for (RedEnemyMoving enemy : RedEnemyMoving.getRedEnemyMovingArrayList()) {
                enemy.addCollisionListener(new PortalListener(portalFrom, portalTo));
            }
            for (RedEnemyStatic enemy : RedEnemyStatic.getRedEnemyStaticArrayList()) {
                enemy.addCollisionListener(new PortalListener(portalFrom, portalTo));
            }
            for (BlueEnemyMoving enemy : BlueEnemyMoving.getBlueEnemyMovingArrayList()) {
                enemy.addCollisionListener(new PortalListener(portalFrom, portalTo));
            }
            for (BlueEnemyStatic enemy : BlueEnemyStatic.getBlueeEnemyStaticArrayList()) {
                enemy.addCollisionListener(new PortalListener(portalFrom, portalTo));
            }

            portalTo = null;
            portalFrom = null;
            Controller.setCreatingPortal(false);
        } else if (Controller.isCreatingPortal()) {
            portalFrom = new PortalFrom(world);
            portalFrom.setPosition(view.viewToWorld(e.getPoint()));
            System.out.println("click again to create second portal!");
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
