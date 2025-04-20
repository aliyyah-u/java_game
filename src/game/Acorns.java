package game;

import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Acorns extends DynamicBody {

    private static final Shape acornShape = new CircleShape(0.5f);

    private static final BodyImage image = new BodyImage("data/acorn.png", 2f);

    //sound for when enemy is shot

    private static SoundClip acornsSound;

    static {
        try {
            acornsSound = new SoundClip("data/Percussions3.wav");
            System.out.println("Loading acorns sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Acorns(World world) {
        super(world, acornShape);
        addImage(image);
        //setAlwaysOutline(true);
    }

    //when enemy is shot then sound plays and enemy disappears

    @Override
    public void destroy()
    {
        acornsSound.play();
        super.destroy();
    }
}

