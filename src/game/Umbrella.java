package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

/**
 * one of the toolkit items to use
 */
public class Umbrella extends ToolkitItem {
    public Umbrella(Mei mei) {
        super(mei);

        image = new BodyImage("data/openumbrella.png",8f);
    }

    @Override
    public String getType() {
        return "Umbrella";
    }

    @Override
    public void operate() {
        System.out.println("fly");
        mei.setLinearVelocity(new Vec2(0,5));
    }

    @Override
    public void wear() {
        super.wear();

        aImage.setOffset(new Vec2(0, 1));
    }
}
