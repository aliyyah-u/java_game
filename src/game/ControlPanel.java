package game;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton playButton;
    private JButton pauseButton;
    private JButton restartButton;
    private JButton instructionsButton;
    private GameLevel level;
    private GameView view;
    private MeiController controller;
    private Game game;



    public ControlPanel(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restartLevel();
            }
        });
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructionsButton.addActionListener(new InstrucButtonPress());
            }
        });
    }

    public void setLevel(GameLevel level) {
        this.level = level;
    }

    public JPanel getMainPanel() {
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.stop();
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.start();
            }
        });
        return mainPanel;
    }
}
