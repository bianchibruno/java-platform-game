package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class DoorListener implements CollisionListener {
    private Game game;

    public DoorListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Player player = game.getPlayer();
        if(e.getOtherBody() == player && game.isCurrentLevelCompleted()){
            System.out.println("Level cleared");
            game.goNextLevel();
        }
    }
}
