package aventura.java.gui;

import aventura.java.Main;
import aventura.java.gamelogic.Game;

import javax.swing.*;
import java.awt.*;

public class GameGui extends GuiBase {
    private final JLabel Score;
    private final Game game;
    private final Timer timer;

    public GameGui(String name, int width, int height, int gameWidth, int gameHeight) {
        super(name, width, height);
        this.game = new Game(gameWidth, gameHeight);
        this.Frame.setResizable(false);
        this.Frame.addKeyListener(new KeyListener(this.game));

        JPanel background = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        background.setBackground(Color.BLACK);

        this.Score = new JLabel();
        this.Score.setText("Score: " + 0);
        this.Score.setFont(new Font(Score.getFont().getFontName(), Font.BOLD, 24));
        this.Score.setForeground(new Color(90, 5, 140));
        this.Score.setHorizontalTextPosition(SwingConstants.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 0;
        background.add(this.Score, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1;
        constraints.weightx = 1;
        background.add(game.getGamePanel(), constraints);
        this.container.add(background);

        this.timer = new Timer(200, (e -> this.run()));
        this.timer.start();
    }

    private void run() {
        this.game.run();
        Score.setText("Score: " + this.game.getScore());
        this.container.repaint();
        if (!this.game.getSnake().getIsSnakeAlive()) {
            this.timer.stop();
            Main.startGameMenu();
            this.Frame.dispose();
        }
    }
}
