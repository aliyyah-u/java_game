package game;

import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Snowflakes extends DynamicBody {

    private static final Shape snowflakeShape = new CircleShape(1f);

    private static final BodyImage image = new BodyImage("data/snowflake.png", 1f);

    private static SoundClip snowflakeSound;

    static {
        try {
            snowflakeSound = new SoundClip("data/sparkle.wav");
            System.out.println("Loading snowflake sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Snowflakes(World world) {
        super(world, snowflakeShape);
        addImage(image);
        //setAlwaysOutline(true);
    }

    //collectible
    @Override
    public void destroy()
    {
        snowflakeSound.play();
        super.destroy();
    }
}
