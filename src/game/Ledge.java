package game;

import city.cs.engine.*;

public class Ledge extends StaticBody {

    private static final Shape ledgeShape = new BoxShape(5, 0.25f);

    private static final BodyImage image = new BodyImage("data/ledge.png",3.5f);

    public Ledge(World world) {
        super(world, ledgeShape);
        addImage(image);
        //setAlwaysOutline(true);
    }
}
