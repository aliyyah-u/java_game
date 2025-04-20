package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SnowflakesPickup implements CollisionListener {

    private Mei mei;
    public SnowflakesPickup(Mei m){
        this.mei = m;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Snowflakes) {
            mei.addSnowflakes();
            e.getOtherBody().destroy();
        }
    }
}
