package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.*;

public class GameView extends UserView {

    private Game game;
    GameLevel level;

    public GameView(Game game, GameLevel w, int width, int height) {
        super(w, width, height);
        this.game = game;
        level = w;
    }

    @Override
    public void setWorld(World w){
        super.setWorld(w);
        level = (GameLevel) w;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(level.getBackground(), -100, -150, this);
    }


    //showing scores on frame
    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        g.setFont(new Font("Calibri", Font.BOLD, 15));
        g.setColor(Color.black);

        g.drawString("Acorn score: " + level.getMei().getAcornCount(), 10, 20);
        g.drawString("Soot sprite score: " + level.getMei().getSoots(), 160, 20);
        g.drawString("Snowflake score: " + level.getMei().getSnowflakeCount(), 345, 20);
        //g.drawString(game.getTimer().start());


        //showing gameover message when character lost level
        if (game.isGameOver()){
            g.setFont(new Font("Calibri", Font.PLAIN, 50));
            g.drawString("GameOver", 150 , this.getHeight()/2);
        }
    }
}

