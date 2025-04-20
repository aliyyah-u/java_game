package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class FoundTotoro implements CollisionListener{

    private GameLevel level;
    private Game game;


    //level completed sound
    private static SoundClip completeSound;

    static {
        try {
            completeSound = new SoundClip("data/complete.mp3");
            System.out.println("Loading game level passed sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    public FoundTotoro(GameLevel level, Game game){
        this.level = level;
        this.game = game;
        }

        @Override
        public void collide(CollisionEvent e) {
            //if Mei collides with totoro and the
            //conditions for completing the level are fulfilled
            //goToNextLevel
            if (e.getOtherBody() instanceof Totoro
                    && level.isComplete()){
                completeSound.play();
                game.goToNextLevel();
            }
    }
}

