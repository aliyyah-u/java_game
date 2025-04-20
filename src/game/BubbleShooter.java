package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

public class BubbleShooter extends ToolkitItem {
    public BubbleShooter(Mei mei) {
        super(mei);

        image = new BodyImage("data/bubbleshooter.png",6f);
    }

    @Override
    public String getType() {
        return "Bubble shooter";
    }

    //when character shoots a message is also printed
    @Override
    public void operate() {
        System.out.println("shoot");
        mei.shoot();
    }


    //can wear the gun
    @Override
    public void wear() {
        super.wear();

        aImage.setOffset(new Vec2(1, 0));
    }
}
