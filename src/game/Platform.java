package game;

import city.cs.engine.*;

public class Platform extends StaticBody {

    private static final Shape platformShape = new BoxShape(3, 0.25f);

    private static final BodyImage image = new BodyImage("data/clouds.png",18);

    public Platform(World world) {
        super(world, platformShape);
        addImage(image);
        //setAlwaysOutline(true);
    }

}

