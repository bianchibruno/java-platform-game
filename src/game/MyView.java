package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class MyView extends UserView {
    //    private GameLevel world;
    private Image lifes3 = new ImageIcon("data/3lifes.png").getImage();
    private Image lifes2 = new ImageIcon("data/2lifes.png").getImage();
    private Image lifes1 = new ImageIcon("data/1lifes.png").getImage();
    private Image lifes0 = new ImageIcon("data/0lifes.png").getImage();
    private Image frame = new ImageIcon("data/blueFrame.png").getImage();


    private GameLevel currentLevel;

    public MyView(GameLevel world, int width, int height) {
        super(world, width, height);
    }

    public void setCurrentLevel(GameLevel world) {
        currentLevel = world;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        g.drawImage(currentLevel.getBackgroundImage(),0,0,null);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        //print lifes on screen
        if (currentLevel.getPlayer().getLifes() == 3) {
            g.drawImage(lifes3, 50, 50, null);
        } else if (currentLevel.getPlayer().getLifes() == 2) {
            g.drawImage(lifes2, 50, 50, null);
        } else if (currentLevel.getPlayer().getLifes() == 1) {
            g.drawImage(lifes1, 50, 50, null);
        } else if (currentLevel.getPlayer().getLifes() == 0) {
            g.drawImage(lifes0, 50, 50, null);
        }
        g.setColor(Color.BLACK);
        g.setFont(Font.getFont(Font.SANS_SERIF));
        g.drawString("ammo left: " + currentLevel.getPlayer().getAmmoLeft(), 50, 100);
        g.drawString("portals left: " + currentLevel.getPlayer().getPortalsLeft(), 50, 120);
        g.drawImage(frame, getWidth() / 2, 20, null);
        if (!Controller.isCreatingPortal() && !(currentLevel instanceof Level1)) {
            g.drawImage(new ImageIcon("data/souls2.png").getImage(), getWidth() / 2 + 7, 25, null);
        } else if (Controller.isCreatingPortal()) {
            g.drawImage(new ImageIcon("data/spellBook1.png").getImage(), getWidth() / 2 + 10, 28, null);
        }

    }

}

