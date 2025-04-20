package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level2 extends GameLevel{
    private static final BodyImage image = new BodyImage("data/clouds.png",14);

    private static final BodyImage gimage = new BodyImage("data/clouds.png",100);

    Image background;

    private SoundClip music;

    public Level2(Game game) {
        super(game);

        try {
            music = new SoundClip("data/bmusic.mp3");
            music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }


        background = new ImageIcon("data/sunset.png").getImage();

        getToto().setPosition(new Vec2(-8f, 7.5f));
        getMei().setPosition(new Vec2(10, -11));

        getMei().addCollisionListener(new AcornsPickup(getMei()));
        getMei().addCollisionListener(new SnowflakesPickup(getMei()));

        // make the ground
        Shape shape = new BoxShape(12.5f, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -12.5f));
        ground.addImage(gimage);
        ground.setClipped(true);

        // make platforms
        Platform platform1 = new Platform(this);
        platform1.setPosition(new Vec2(-7, 6f));

        Platform platform2 = new Platform(this);
        platform2.setPosition(new Vec2(9, -7));

        Lift lift = new Lift(this);
        lift.setPosition(new Vec2(-0, -6));
        lift.addImage(image);

        //create some pickups (snowflakes)
        //(on the ground)
        for (int i = 0; i < 5; i++) {
            Snowflakes snowflakes = new Snowflakes(this);
            snowflakes.setPosition(new Vec2(-4f, -7));
        }

        //on clouds
        for (int i = 0; i < 3; i++) {
            Snowflakes snowflakes = new Snowflakes(this);
            snowflakes.setPosition(new Vec2(8, -5.5f));
        }

        //(on the clouds)
            Snowflakes snowflakes1 = new Snowflakes(this);
            snowflakes1.setPosition(new Vec2(-0, -2));

            //make butterfly collectibles
        Butterflies butterfly = new Butterflies(this);
        butterfly.setPosition(new Vec2(7f,10.8f));
        butterfly.setGravityScale(0);
    }

    @Override
    public boolean isComplete() {
        if (getMei().getSnowflakeCount() >= 3)
            return true;
        else
            return false;
    }

    @Override
    public Image getBackground() {
        return background;
    }

    @Override
    public String getName(){
        return "Level2";
    }

    @Override
    public SoundClip getMusic() {
        return music;
    }
}
