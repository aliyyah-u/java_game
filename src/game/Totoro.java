package game;

import city.cs.engine.*;

public class Totoro extends Walker {

    private static final Shape totoroShape = new PolygonShape(
            1.84f, 1.99f, 1.96f, -0.3f, 1.5f, -2.36f,
            -0.47f, -2.33f, -1.98f, 1.69f, 0.5f, 2.46f);

    private static final BodyImage image =
            new BodyImage("data/Totoro.gif", 5f);


    public Totoro(World world) {
        super(world, totoroShape);
        addImage(image);
    }
}

