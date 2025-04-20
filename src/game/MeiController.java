package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;


/**
 * character controlled by keys pressed
 */
public class MeiController implements KeyListener {
    private static final float WALKING_SPEED = 8;
    private static final float JUMPING_SPEED = 10;
    private Mei mei;
    private Game game;


    /**
     * declaring character and game
     * @param m the character
     * @param game the game
     */
    public MeiController(Mei m, Game game) {
        mei = m;
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

  /**
     * key pressed method, listens for key event e
     *
     * if right arrow pressed character moves right & has a walking gif attached,
     * vice versa for left arrow,
     * if space bar pressed character jumps,
     * if q pressed toolkit items are toggled between,
     * if w pressed then can use toolkit item,
     * if escape button pressed then menu is toggled from visible to not visible
     * @param e key action event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_RIGHT) {
            mei.startWalking(WALKING_SPEED);
            mei.removeAllImages();
            mei.addImage(new BodyImage("data/Mei.gif", 4.5f));
        } else if (code == KeyEvent.VK_LEFT) {
            mei.startWalking(-WALKING_SPEED);
            mei.removeAllImages();
            mei.addImage(new BodyImage("data/Mei.gif", 4.5f));
            List<AttachedImage> allImages = mei.getImages();
            for (AttachedImage im : allImages) {
                im.flipHorizontal();
            }
        } else if (code == KeyEvent.VK_SPACE) {
            mei.jump(JUMPING_SPEED);
        } else if (code == KeyEvent.VK_Q) {
            mei.getToolkit().toggle();
        } else if (code == KeyEvent.VK_W) {
            mei.getToolkit().getCurrentItem().operate();
        }
        else if (code == KeyEvent.VK_ESCAPE){
            game.toggleMenu();
        }

           /* else if (code == KeyEvent.VK_S){
                try{
                //    GameSaverLoader.save("data/save.txt", level);
                } catch (IOException ee){
                    ee.printStackTrace();
                }
            }
            else if (code == KeyEvent.VK_L){
                try{
                //    GameLevel loadedLevel = GameSaverLoader.load("data/save.txt", level);
                //    getClass(game).setLevel(loadedLevel);
                }
                catch (IOException ee){
                    ee.printStackTrace();
                }
            }*/
    }


    /**
     * method listens for release of keys
     * if left/ right arrow released then character stops moving & still image of character is attached
     * @param e key action event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            mei.stopWalking();
            mei.setLinearVelocity(new Vec2(0, 0));
            mei.removeAllImages();
            mei.addImage(new BodyImage("data/Meistill.png", 4.5f));
            List<AttachedImage> allImages = mei.getImages();
            for (AttachedImage im : allImages) {
                im.flipHorizontal();
            }
        } else if (code == KeyEvent.VK_RIGHT) {
            mei.stopWalking();
            mei.setLinearVelocity(new Vec2(0, 0));
            mei.removeAllImages();
            mei.addImage(new BodyImage("data/Meistill.png", 4.5f));
        }
    }

    /**
     * updates character to correct version
     * @param mei my character
     */
    public void updateMei(Mei mei) {
        this.mei = mei;
    }
}
