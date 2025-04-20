package game;

import city.cs.engine.UserView;
import java.awt.*;
import javax.swing.JFrame;

/** Your main game entry point
 * @author Aliyyah Uddin, aliyyah.uddin@city.ac.uk
 */

public class Game {

    private boolean gameOver;

    private GameLevel level;

    private final GameView view;

    private final MeiController controller;

    private final UserView wideView;

    private final ControlPanel buttons;

    private Tracker tracker;

    private  boolean menuVisible;

    private JFrame frame;


    /**
     * Initialise a new Game.
     */

    public Game() {

        /**
         * game over is set to false since the condition failing the game will not have been fulfilled as soon as game starts
         */

        gameOver = false;

        /**
         * toggle menu is not to be shown at the start of the game, until user presses escape button
         */
        menuVisible = false;


        //1. make an empty game world
        level = new Level1(this) {
        };

        //3. make a view to look into the game world
        view = new GameView(this, level, 500, 500);
        view.setCentre(level.getMei().getPosition());

        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);

        /**
         * control character to be able to move based on using arrow keys
         */
        controller = new MeiController(level.getMei(), this);
        view.addKeyListener(controller);


        /**
         * game is only playable if mouse is hovering inside frame of game
         */
        view.addMouseListener(new GiveFocus(view));

        //make character centre of view
        tracker = new Tracker(view, level.getMei());
        level.addStepListener(tracker);

        //4. create a Java window (frame) and add the game view to it
        frame = new JFrame("City Game");
        frame.add(view);

        //make another view and add it at the bottom of the frame
        wideView = new UserView(level, 500, 90);
        wideView.setZoom(3);
        frame.add(wideView, BorderLayout.SOUTH);
        wideView.setBackground(Color.getHSBColor(201,65,79));

        /**
         * adding the buttons such as pause/ play to the control panel
         */
        buttons = new ControlPanel(level, this);
        // frame.add(buttons.getMainPanel(), BorderLayout.NORTH);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(level, 500, 500);

        // start our game world simulation!
        level.start();
        level.getMusic().play();
    }

    /**
     * set level
     * switch from first to second level
     * switch music, view, character controller to new level
     * @param level
     */

    public void setLevel(GameLevel level){
        level.stop();
        level.getMusic().stop();
        level.removeStepListener(tracker);
        level = new Level2(this);
        level.addStepListener(tracker);
        view.setWorld(level);
        wideView.setWorld(level);
        wideView.setZoom(3);
        controller.updateMei(level.getMei());
        level.start();
    }

    /**
     * go to next level
     * music will stop and switch to next level music, view will switch to next level,
     * character will be updated to next level view,
     * wideview of level will switch to next level, buttons will now control next level
     */

    public void goToNextLevel() {

        if (level instanceof Level1) {
            level.stop();
            level.getMusic().stop();
            level.removeStepListener(tracker);
            level = new Level2(this);
            level.addStepListener(tracker);
            view.setWorld(level);
            wideView.setWorld(level);
            wideView.setZoom(3);
            tracker.updateMei(level.getMei());
            controller.updateMei(level.getMei());
            buttons.setLevel(level);
            level.start();
            level.getMusic().play();
        }
        else if (level instanceof Level2) {
            level.stop();
            level.getMusic().stop();
            level.removeStepListener(tracker);
            level = new Level3(this);
            level.addStepListener(tracker);
            view.setWorld(level);
            wideView.setWorld(level);
            wideView.setZoom(3);
            tracker.updateMei(level.getMei());
            controller.updateMei(level.getMei());
            buttons.setLevel(level);
            level.start();
            level.getMusic().play();
        }
        else if (level instanceof Level3) {
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }
    }

    /**
     * restart level
     * when button pressed, level will reload
     */

    public void restartLevel(){
        level.stop();
        level.getMusic().stop();
        gameOver = false;

        if (level instanceof Level1){
            level.removeStepListener(tracker);
            level = new Level1(this);
            level.addStepListener(tracker);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            tracker.updateMei(level.getMei());
            controller.updateMei(level.getMei());
            level.start();
            level.getMusic().play();
        }
        else if (level instanceof Level2) {
            level.removeStepListener(tracker);
            level = new Level2(this);
            level.addStepListener(tracker);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            tracker.updateMei(level.getMei());
            controller.updateMei(level.getMei());
            level.start();
            level.getMusic().play();
        }
        else if (level instanceof Level3) {
            level.removeStepListener(tracker);
            level = new Level3(this);
            level.addStepListener(tracker);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            tracker.updateMei(level.getMei());
            controller.updateMei(level.getMei());
            level.start();
            level.getMusic().play();
        }
    }


    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }


    /**
     * checking what the state of gameOver is
     * @return gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }


    /**
     * game over
     * the level will stop
     * @param over
     */

    public void setGameOver(boolean over){
        gameOver = over;
        level.stop();
        view.repaint();
    }

    /**
     * Toggle menu
     * Press escape button to make the menu visible or not at the north of the frame
     */

    public void toggleMenu(){
        if (menuVisible){
            //hide menu
            frame.remove(buttons.getMainPanel());
            menuVisible = false;
            frame.pack();
            level.start();

        }
        else{
            //show menu
            frame.add(buttons.getMainPanel(), BorderLayout.NORTH);
            menuVisible = true;
            frame.pack();
            level.stop();
        }
    }
}
