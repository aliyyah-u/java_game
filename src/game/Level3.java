package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Level3 extends GameLevel implements ActionListener {

    Image background;

    private static final BodyImage image = new BodyImage("data/purple.png",0.5f);

    private SoundClip music;

    Platform platform1;

    Platform platform;

    private Timer timer;


    public Level3(Game game){
        super(game);

       timer = new Timer (3000, this);
       this.timer.setInitialDelay(2000);
       this.timer.start();

        try {
            music = new SoundClip("data/b3music.mp3");
            music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        background = new ImageIcon("data/nightsky.png").getImage();

        getToto().setPosition(new Vec2(4f, 5f));
        getMei().setPosition(new Vec2(10, -11));

        getMei().addCollisionListener(new AcornsPickup(getMei()));

        // make the ground
        Shape shape = new BoxShape(12.5f, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -12.5f));
        ground.setFillColor(Color.black);

        //make moving enemies
        for (int i=0; i<8; i++){
            Soot soot = new Soot(this);
            soot.setPosition(new Vec2(-3, -9));
        }

        for (int i=0; i<5; i++){
            Soot soot1 = new Soot(this);
            soot1.setPosition(new Vec2(-9f,6f));
            soot1.setGravityScale(0);
        }

        for (int i=0; i<3; i++){
            Soot soot2 = new Soot(this);
            soot2.setPosition(new Vec2(5f,4f));
            soot2.setGravityScale(0);
        }

        for (int i=0; i<2; i++){
            platform = new Platform(this);
            platform.removeAllImages();
            platform.addImage(image);
            platform.setPosition(new Vec2(i*4f, i*5f));
            platform1 = new Platform(this);
            platform1.removeAllImages();
            platform1.addImage(image);
            platform1.setPosition(new Vec2(i*-4f, i*-5f));
            platform.setClipped(true);
            platform1.setClipped(true);
        }

        //make more acorn pickups
        for (int i=0; i<4; i++){
            Acorns acorns = new Acorns(this);
            acorns.setPosition(new Vec2(i*4f, -5));
        }
    }

    @Override
    public boolean isComplete() {
        if (getMei().getAcornCount() >= 3)
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
        return "Level3";
    }

    @Override
    public SoundClip getMusic() {
        return music;
    }

    //actions occurring based on a timer
   @Override
    public void actionPerformed(ActionEvent e) {
        platform1.setAngleDegrees(platform1.getAngleDegrees()+30);
        Soot spawn = new Soot(this);
        spawn.setPosition(new Vec2(-3,-9));
    }
}
