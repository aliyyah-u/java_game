package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class AcornsPickup implements CollisionListener {

    private Mei mei;
    public AcornsPickup(Mei m){
        this.mei = m;
    }


    //when character touches acorn the acorns disappear and a point is added to score
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Acorns) {
            mei.addAcorns();
            e.getOtherBody().destroy();
        }
    }
}
