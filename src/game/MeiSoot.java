package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * condition for whether game over is true
 */
public class MeiSoot implements CollisionListener  {

    private Mei mei;

    private Game game;

    public MeiSoot(Game game, Mei m){
        this.mei = m;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Soot) {
                game.setGameOver(true);
        }
    }
}


