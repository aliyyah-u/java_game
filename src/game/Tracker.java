package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**
 * view is based on centre of character
 */
public class Tracker implements StepListener {

    private GameView view;
    private Mei mei;


    public Tracker(GameView view, Mei mei) {
        this.view = view;
        this.mei = mei;
    }
    public void preStep(StepEvent e) {
    }
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(mei.getPosition().x, 0));
    }

    public void updateMei(Mei newMei){mei = newMei;}

}

