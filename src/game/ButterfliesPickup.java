package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ButterfliesPickup implements CollisionListener {

    private Mei mei;
    public ButterfliesPickup(Mei m){
        this.mei = m;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Butterflies) {
            mei.addButterflies();
            e.getOtherBody().destroy();
        }
    }
}
