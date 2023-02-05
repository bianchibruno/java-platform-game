package game;

import city.cs.engine.Body;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {

    private WorldView view;
    private GameLevel world;
    private int timer = 0;

    public Tracker(WorldView view, GameLevel world){
        this.view = view;
        this.world = world;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
    timer++;
    Player player = world.getPlayer();
    Vec2 v = player.getLinearVelocity();

    //CONTROL OF ENEMIES IMAGES
    for(Body body : world.getDynamicBodies()){
        Vec2 vel = body.getLinearVelocity();
        if(body instanceof RedEnemyMoving){
            if(vel.x > 0){
                ((RedEnemyMoving) body).changeImage(RedEnemyMoving.getRedEnemyRight());
            } else if (vel.x < 0) {
                ((RedEnemyMoving) body).changeImage(RedEnemyMoving.getRedEnemyLeft());
            } else {
                ((RedEnemyMoving) body).changeImage(RedEnemyMoving.getRedEnemyRest());
            }
        }

        if(body instanceof BlueEnemyMoving){
            if(vel.x > 0){
                ((BlueEnemyMoving) body).changeImage(BlueEnemyMoving.getBlueEnemyRight());
            } else if (vel.x < 0) {
                ((BlueEnemyMoving) body).changeImage(BlueEnemyMoving.getBlueEnemyLeft());
            } else {
                ((BlueEnemyMoving) body).changeImage(BlueEnemyMoving.getBlueEnemyRest());
            }
        }
    }

    //Change enemies' walking directions
    for(RedEnemyMoving enemy : RedEnemyMoving.getRedEnemyMovingArrayList()){
        if(timer%120 == 0){
            enemy.startWalking(-1 * enemy.getLinearVelocity().x);
        }
    }
    for(BlueEnemyMoving enemy : BlueEnemyMoving.getBlueEnemyMovingArrayList()){
        if(timer%120 == 0){
            enemy.startWalking(-1 * enemy.getLinearVelocity().x);
        }
    }

        //CONTROL OF PLAYER IMAGES
        if(!player.isGliding()) {
            if (v.x > 0 && !player.isJumping()) {
                player.changeImage(Player.getGifRight());// moving right no jumping --> gif right
            } else if (v.x < 0 && !player.isJumping()) {
                player.changeImage(Player.getGifLeft());// moving left no jumping --> gif left
            } else if (v.x > 0 && player.isJumping()) {
                player.changeImage(Player.getJumpRight());// moving right jumping --> jump right
            } else if (v.x < 0 && player.isJumping()) {
                player.changeImage(Player.getJumpLeft());// moving left jumping --> jump left
            } else if (v.x == 0 && !player.isJumping()) {
                if (player.isMovedRight()) {
                    player.changeImage(Player.getImageRight());
                } else {
                    player.changeImage(Player.getImageLeft());
                }
            }
        } else if (player.isGliding() && player.isCanGlide()) {
            player.changeImage(Player.getParachuteImage());
            player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, -0.5f));
        }
        //KILL PLAYER IF FALLS BELOW -20
        if (player.getPosition().y < -20) {
            player.decreaseLifes();
        }
        if (Controller.isCreatingPortal()) {
            player.setPosition(Controller.getSavedPos());
        }

    }

    @Override
    public void postStep(StepEvent stepEvent) {
        view.setCentre(world.getPlayer().getPosition());
    }
}
