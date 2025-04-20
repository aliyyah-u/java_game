package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstrucButtonPress implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("collectibles: acorns, snowflakes, butterflies");
        System.out.println("find Totoro");
        System.out.println("avoid soot sprites - game over if you touch them");
        System.out.println("toggle between tools by pressing 'q' and use the tools by pressing 'w' ");
        System.out.println("umbrella makes character fly & bubble shooter is used to shoot soot sprites");
        System.out.println("move using left and right arrow keys & jump using space bar");
        System.out.println("scores are displayed on the screen");
    }
}
