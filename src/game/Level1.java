package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level1 extends GameLevel{

    private static final BodyImage image = new BodyImage("data/ledge.png",3f);
    private static final BodyImage gimage = new BodyImage("data/ledge.png",9f);
    Image background;


    //background music
    private SoundClip music;

    public Level1(Game game){
        super(game);

        try {
            music = new SoundClip("data/b2music.mp3");
            music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        background = new ImageIcon("data/forest.jpg").getImage();


        getMei().setPosition(new Vec2(-10f,-10.8f));
        getToto().setPosition(new Vec2(-8, 8f));

        getMei().addCollisionListener(new AcornsPickup(getMei()));

        // make the ground
        Shape shape = new BoxShape(12.5f, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -12f));
        ground.addImage(gimage);
        ground.setClipped(true);

        // make a platform
        city.cs.engine.Shape platform1Shape = new BoxShape(4, 0.35f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-3, -8.5f));
        platform1.addImage(image);

        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(1, -4f));
        platform2.addImage(image);

        //create a group of ledges
        for (int i=0; i<3; i++){
            Ledge ledge = new Ledge(this);
            ledge.setPosition(new Vec2(-8*i, i*6f));
        }

        //create some pickups (acorns)
        for (int i=-1; i<1; i++){
            Acorns acorns = new Acorns(this);
            acorns.setPosition(new Vec2(i*2f,-7));
        }

        for (int i=-1; i<3; i++){
            Acorns acorns = new Acorns(this);
            acorns.setPosition(new Vec2(i*2f,0));
        }

        Acorns acorns = new Acorns(this);
        acorns.setPosition(new Vec2(1,-4.5f));

        //make moving enemies
        Soot soot = new Soot(this);
        soot.setPosition(new Vec2(7f,-10.8f));

        Soot soot1 = new Soot(this);
        soot1.setPosition(new Vec2(9f,-6f));
        soot1.setGravityScale(0);
    }

    //determine whether to go to next level
    @Override
    public boolean isComplete() {
        if (getMei().getAcornCount() >= 1)
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
        return "Level1";
    }

    @Override
    public SoundClip getMusic() {
        return music;
   }
}
