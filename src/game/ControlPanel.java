package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener {
    private JButton pausePlay;
    private JButton changeLevel;
    private JButton exit;
    private JButton restart;

    private Game game;
    private boolean worldStopped;

    public ControlPanel(Game game) {
        this.game = game;

        worldStopped = false;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        pausePlay = new JButton("pause");
        pausePlay.setFocusable(false);
        this.add(pausePlay);
        changeLevel = new JButton("goNextLevel");
        changeLevel.setFocusable(false);
        this.add(changeLevel);
        exit = new JButton("exit");
        exit.setFocusable(false);
        this.add(exit);
        restart = new JButton("restart");
        restart.setFocusable(false);
        this.add(restart);

        restart.addActionListener(this);
        pausePlay.addActionListener(this);
        changeLevel.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pausePlay) {
            if (worldStopped) {
                worldStopped = false;
                game.getWorld().start();
            } else {
                worldStopped = true;
                game.getWorld().stop();
            }
        } else if (e.getSource() == changeLevel) {
            game.goNextLevel();
        } else if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == restart){
            game.getFrame().dispose();
            new Game();
        }
    }
}
