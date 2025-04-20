package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.*;
import java.util.List;


/**
 * moving character
 */
public class Mei extends Walker {

    private static final Shape meiShape = new PolygonShape(0.29f,1.22f,
            0.67f,0.05f,
            0.8f,-1.32f,
            0.3f,-1.87f,
            -0.62f,-1.85f,
            -0.98f,0.73f);



    private static final  BodyImage rightimage =
                new BodyImage("data/Meistill.png", 4.5f);

    private static final BodyImage walkImage =
            new BodyImage("data/Mei.gif", 4.5f);

    private int credits;
    private String direction;
    private int acornCount;
    private Toolkit toolkit;
    private AttachedImage aImage;
    private int snowflakeCount;
    private int sootCount;
    private int butterflyCount;


    /**
     * character has an image attached based on key pressed,
     * has images of toolkit items,
     * scores due to collectibles
     * @param world based on level and view
     */
    public Mei(World world) {
            super(world, meiShape);
            aImage = addImage(rightimage);
            credits = 0;
            direction = "right";
            //setAlwaysOutline(true);
            toolkit = new Toolkit();
            acornCount = 0;
            snowflakeCount = 0;
            sootCount = 0;
            butterflyCount = 0;
        }

        public int getCredits() {
        return credits;
    }


    @Override
    public void startWalking(float speed) {
        super.startWalking(speed);

        if (speed < 0 && direction.equals("right")) {

            List<AttachedImage> allImages = this.getImages();
            for (AttachedImage im : allImages) {
                im.flipHorizontal();
            }
            direction = "left";
        }
        else if (speed > 0 && direction.equals("left")) {

            List<AttachedImage> allImages = this.getImages();

            for (AttachedImage im : allImages) {
                im.flipHorizontal();
            }
            direction = "right";
        }
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setSoots(int sootCount) {
        this.sootCount = sootCount;

        System.out.println("sootCount = " + sootCount);
    }

    public int getSoots(){
        return sootCount;
    }

    public Toolkit getToolkit(){
        return toolkit;
    }

    public String getDirection(){
        return direction;
    }

    /**
     * bubble shooter
     * the bubbles have a linear velocity that gives a slightly curved trajectory,
     * bubbles are blue
     * listener for whether bubble touches enemy
     */
    public void shoot(){

        DynamicBody bubble = new DynamicBody(this.getWorld() , new CircleShape(0.2f));

        if (direction.equals("left")) {
            bubble.setPosition(new Vec2(this.getPosition().x -1, this.getPosition().y));
            bubble.setLinearVelocity(new Vec2(-25, -5));
        }
        else {
            bubble.setPosition(new Vec2(this.getPosition().x +1, this.getPosition().y));
            bubble.setLinearVelocity(new Vec2(25, -5));
        }
        bubble.setFillColor(Color.blue);

        BubbleImpact impact = new BubbleImpact(this);
        bubble.addCollisionListener(impact);

        //Mei.addCollisionListener(impact);
        //if( impact = true) {
          //  getGameL.setGameOver(true);
        //}
    }

    public void shoot(Vec2 t){

        DynamicBody bubble = new DynamicBody(this.getWorld() , new CircleShape(0.2f));
        bubble.setFillColor(Color.blue);

        Vec2 dir = t.sub(this.getPosition());
        dir.normalize();

        bubble.setPosition(this.getPosition().add(dir.mul(1f)));
        bubble.setLinearVelocity(dir.mul(30));
    }

        public void addAcorns(){
            acornCount++;
            System.out.println("Getting closer: " +
                    "acornCount = " + acornCount);
        }
        public int getAcornCount(){
            return acornCount;
        }

    public void addSnowflakes(){
        snowflakeCount++;
        System.out.println("Getting closer: " +
                "snowflakeCount = " + snowflakeCount);
    }
    public int getSnowflakeCount(){
        return snowflakeCount;
    }

    public void addImage(AttachedImage aImage) {
    }

    public void addButterflies() {
        butterflyCount++;
        System.out.println("butterflyCount = " + butterflyCount);
    }
    public int getButterflyCount(){
        return butterflyCount;
    }
}

