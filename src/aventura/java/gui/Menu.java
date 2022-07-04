package aventura.java.gui;

import aventura.java.Main;

import javax.swing.*;
import java.awt.*;

public class Menu extends GuiBase {
    private final Timer timer;
    private Garry garry;

    public Menu() {
        super("Snake Menu", 400, 400);
        this.Frame.setResizable(false);
        this.container.setVisible(false);

        JPanel Background = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        Background.setBackground(Color.BLACK);
        this.container.add(Background);

        this.timer = new Timer(200, (e -> this.garry.update()));

        //Row 0
        JLabel Title = new JLabel();
        Title.setText("Snake ");
        Title.setFont(new Font(Title.getFont().getFontName(), Font.BOLD, 55));
        Title.setBackground(Color.BLACK);
        Title.setForeground(Main.Purple);
        Title.setHorizontalTextPosition(SwingConstants.CENTER);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 0;
        Background.add(Title, constraints);

        this.garry = new Garry(5, 5, 11);
        this.garry.getGamePanel().setBorder(null);
        constraints.gridwidth = 1;
        constraints.gridx = 2;
        constraints.gridy = 0;
        Background.add(this.garry.getGamePanel(), constraints);

        //Row 1
        JPanel BlackSpacing = new JPanel();
        BlackSpacing.setBackground(Color.BLACK);
        constraints.gridwidth = 3;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.ipady = 40;
        Background.add(BlackSpacing, constraints);

        //Row 2
        JButton newButton = new JButton("Play");
        newButton.setContentAreaFilled(false);
        newButton.setForeground(Main.Purple);
        newButton.addActionListener(e -> this.newGame());
        constraints.gridwidth = 3;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.ipady = 10;
        Background.add(newButton, constraints);

        //Row 3
        JButton SizeButton = new JButton("Size");
        SizeButton.setContentAreaFilled(false);
        SizeButton.setForeground(Main.Purple);
        SizeButton.addActionListener(e -> this.sizeGUI());
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.anchor = GridBagConstraints.SOUTH;
        Background.add(SizeButton, constraints);

        JPanel BlackSpacing3 = new JPanel();
        BlackSpacing3.setBackground(Color.BLACK);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.ipady = 90;
        Background.add(BlackSpacing3, constraints);

        JButton ColorButton = new JButton("Color");
        ColorButton.setContentAreaFilled(false);
        ColorButton.setForeground(Main.Purple);
        ColorButton.addActionListener(e -> this.colorGUI());
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.ipadx = 0;
        constraints.ipady = 0;
        Background.add(ColorButton, constraints);

        this.container.setVisible(true);
        this.timer.start();
    }

    private void sizeGUI() {
        new SizeChanger("Change Game Size", 300, 150);
    }

    private void colorGUI() {
        new ColorChanger("Change Snake Color", 400, 250);
    }

    private void newGame() {
        this.timer.stop();
        this.Frame.dispose();
        Main.startGame();
    }
}
