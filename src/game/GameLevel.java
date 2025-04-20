package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class GameLevel extends World {

    private final Totoro toto;
    private final Mei mei;

    private Game game;
    private static final BodyImage image = new BodyImage("data/ledge.png",9f);

    public GameLevel(Game game) {

        this.game = game;

        //characters
        toto = new Totoro(this);
        mei = new Mei(this);


        //pickups
        FoundTotoro found = new FoundTotoro(this, game);
        mei.addCollisionListener(found);

        ButterfliesPickup pickup = new ButterfliesPickup(mei);
        mei.addCollisionListener(pickup);

        MeiSoot touch = new MeiSoot(game, mei);
        mei.addCollisionListener(touch);

        //mei.setCredits(mei.getCredits()+15);

        mei.getToolkit().addItem(new Umbrella(mei));
        mei.getToolkit().addItem(new BubbleShooter(mei));

    }

    public Mei getMei() { return mei; }
    public Totoro getToto() { return toto;}
    public abstract boolean isComplete();
    public abstract Image getBackground();
    public abstract SoundClip getMusic();
    public abstract String getName();
}
