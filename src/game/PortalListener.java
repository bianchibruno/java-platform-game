package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.Walker;

public class PortalListener implements CollisionListener {
    private PortalFrom portalFrom;
    private PortalTo portalTo;

    public PortalListener(PortalFrom portalFrom, PortalTo portalTo){
        this.portalFrom = portalFrom;
        this.portalTo = portalTo;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == portalFrom && e.getReportingBody() instanceof Walker){
            e.getReportingBody().setPosition(portalTo.getPosition().add(e.getNormal()));
            System.out.println("Portal used!");
        }
//        else if (e.getOtherBody() == portalTo && e.getReportingBody() instanceof Walker){
//            e.getReportingBody().setPosition(portalFrom.getPosition().add(e.getNormal()));
//        }

    }
}
