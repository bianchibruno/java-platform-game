package game;
import city.cs.engine.*;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.*;

public class Game {
    private GameLevel world;
    private MyView view;
    private int level;
    private Controller controller;
    private Tracker tracker;
    private CreatingPortal crp;
    private ControlPanel controlPanel;
    private JFrame frame;
    private GiveFocus gf;

    public JFrame getFrame() {
        return frame;
    }

    public Game() {
        level = 1;
        world = new Level1();
        world.populate(this);


        view = new MyView(world, 1000, 1000 );
        view.setCurrentLevel(world);
//        view.setGridResolution(1);
        frame = new JFrame("MyGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(view);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
        frame.requestFocus();
        gf = new GiveFocus(frame);
        view.addMouseListener(gf);
        view.addMouseListener(new Shooting(view, world.getPlayer(), world));
        controlPanel = new ControlPanel(this);
        frame.add(controlPanel, BorderLayout.WEST);
        crp = new CreatingPortal(world, world.getPlayer(), view);
        view.addMouseListener(crp);
        controller = new Controller(world.getPlayer());
        tracker = new Tracker(view, world);
        frame.addKeyListener(controller);
        world.addStepListener(tracker);
//        JFrame debugView = new DebugViewer(world, view.getWidth(), view.getHeight());
        world.start();
    }

    public Player getPlayer() { return world.getPlayer(); }

    public void goNextLevel() {
        world.stop();
        if(level == 3){
            System.exit(0);
        } else if (level == 1) {
            level++;
            world.getPlayer().storeProperties();
            world = new Level2();
            world.populate(this);
            world.getPlayer().loadProperties();
            world.getPlayer().setCanGlide(false);
            controller.setPlayer(world.getPlayer());
            view.setWorld(world);
            view.setCurrentLevel(world);
            view.addMouseListener(new Shooting(view, world.getPlayer(), world));
    crp = new CreatingPortal(world, world.getPlayer(), view);
            view.addMouseListener(crp);
//            JFrame debugView = new DebugViewer(world, view.getWidth(), view.getHeight());
    tracker = new Tracker(view, world);
            world.addStepListener(tracker);
            world.start();

        } else if (level == 2 ) {
            level++;
            world.getPlayer().storeProperties();
            world = new Level3();
            world.populate(this);
            world.getPlayer().loadProperties();
            world.getPlayer().setCanGlide(true);
            controller.setPlayer(world.getPlayer());
            view.setWorld(world);
            view.setCurrentLevel(world);
            view.addMouseListener(new Shooting(view, world.getPlayer(), world));
            crp = new CreatingPortal(world, world.getPlayer(), view);
            view.addMouseListener(crp);
//            JFrame debugView = new DebugViewer(world, view.getWidth(), view.getHeight());
            tracker = new Tracker(view, world);
            world.addStepListener(tracker);
            world.start();
            System.out.println("welcome to level 3! now you are able to glide.");
            System.out.println("to glide, press E when in the air");
        }
        }


    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    public GameLevel getWorld() {
        return this.world;
    }

    public static void main(String[] args) {
        new Game();
    }


}
