package game;

import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Butterflies extends DynamicBody {

    private static final BodyImage butterflyImage = new BodyImage("data/butterfly.gif", 3);
    private static final Shape butterflyShape = new BoxShape(1,1);

    //sound for when butterfly is collected
    private static SoundClip butterflySound;

    static {
        try {
            butterflySound = new SoundClip("data/butterfly.wav");
            System.out.println("Loading butterfly sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Butterflies(World world) {
        super(world, butterflyShape);
        addImage(butterflyImage);
        //setAlwaysOutline(true);
    }

    //butterfly is collected
    @Override
    public void destroy()
    {
        butterflySound.play();
        super.destroy();
    }
}



