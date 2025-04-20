package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BubbleImpact implements CollisionListener {

    private Mei bubble;

    public BubbleImpact(Mei b){
        this.bubble = b;
    }


    //when bubble from gun touches soot then soot gets destroyed and point is added to score
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Soot) {
            bubble.setSoots(bubble.getSoots()+1);
            e.getOtherBody().destroy();
        }
    }
}
