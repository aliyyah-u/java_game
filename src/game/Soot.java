package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * soot class
 * a moving enemy
 */
public class Soot extends Walker implements StepListener {

    private static final BodyImage sootImage = new BodyImage("data/soot.png", 3);
    private static final Shape sootShape = new BoxShape(0.5f,0.5f);

    private final int SPEED = 4;
    private float left, right;
    private final int RANGE = 3;

    private static SoundClip sootSound;

    static {
        try {
            sootSound = new SoundClip("data/whoosh.mp3");
            System.out.println("Loading soot sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    /**
     * soot has an image added to it
     * moves at a set speed
     * @param world game level
     */
    public Soot(World world) {
        super(world, sootShape);
        addImage(sootImage);
        world.addStepListener(this);
        startWalking(SPEED);
    }

    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-SPEED);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }

    @Override
    public void destroy()
    {
        sootSound.play();
        super.destroy();
    }
}
