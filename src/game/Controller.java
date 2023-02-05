package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private static final float jumpingSpeed = 30;
    public static final float walkingSpeed = 10;
    private Player player;
    private PortalFrom portalFrom;
    private PortalTo portalTo;
    private static boolean creatingPortal = false;
    private static Vec2 savedPos = null;

    public static Vec2 getSavedPos() {
        return savedPos;
    }

    public static boolean isCreatingPortal() {
        return creatingPortal;
    }

    public static void setCreatingPortal(boolean creatingPortal) {
        Controller.creatingPortal = creatingPortal;
    }

    public Controller(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int code = e.getKeyCode();
        Vec2 v = player.getLinearVelocity();


        if (code == KeyEvent.VK_Q)
        {
            System.exit(0);
        }

        else if (code == KeyEvent.VK_SPACE)
        {
            if(Math.abs(v.y) < 0.01f){
                player.jump(jumpingSpeed);
            }
        }
        else if (code == KeyEvent.VK_A)
        {
            player.setMovedRight(false);
            player.startWalking(-walkingSpeed);
        }
        else if (code == KeyEvent.VK_D) {
            player.setMovedRight(true);
            player.startWalking(walkingSpeed);
        } else if (code == KeyEvent.VK_S) {
            player.setLinearVelocity(new Vec2(0, -jumpingSpeed));
        } else if (code == KeyEvent.VK_E && player.getLinearVelocity().y < 0.5f) {
            player.setGliding(true);
        } else if (code == KeyEvent.VK_P && player.getPortalsLeft() > 0 && !creatingPortal) {
            creatingPortal = true;
            savedPos = player.getPosition();
            System.out.println("click to create first portal");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A){
            if (!player.isJumping()) {
                player.stopWalking();
                player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));
            } else {
                player.stopWalking();
            }

        } else if (code == KeyEvent.VK_D) {
            if (!player.isJumping()) {
                player.stopWalking();
                player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));
            } else {
                player.stopWalking();
            }
        } else if (code == KeyEvent.VK_E)
        {
            player.setGliding(false);
        }
    }

    public void setPlayer(Player player){
        this.player = player;
    }
}
