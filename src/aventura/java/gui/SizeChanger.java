package aventura.java.gui;

import aventura.java.Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class SizeChanger extends GuiBase {
    public SizeChanger(String name, int width, int height) {
        super(name, width, height);
        this.Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.Frame.setResizable(false);

        this.container.setVisible(false);
        this.container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        this.container.setBackground(Color.BLACK);

        JLabel widthLabel = new JLabel("Width");
        widthLabel.setFont(new Font(widthLabel.getFont().getFontName(), Font.BOLD, 12));
        widthLabel.setForeground(Main.Purple);
        this.container.add(widthLabel, constraints);

        JLabel heightLabel = new JLabel("Height");
        heightLabel.setFont(new Font(heightLabel.getFont().getFontName(), Font.BOLD, 12));
        heightLabel.setForeground(Main.Purple);
        constraints.gridx = 1;
        this.container.add(heightLabel, constraints);

        JSpinner gameWidth = new JSpinner(new SpinnerNumberModel(Main.gameWidth, 5, 64, 1));
        gameWidth.addChangeListener(e -> this.update(e, true));
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.container.add(gameWidth, constraints);

        JSpinner gameHeight = new JSpinner(new SpinnerNumberModel(Main.gameHeight, 5, 64, 1));
        gameHeight.addChangeListener(e -> this.update(e, false));
        constraints.gridx = 1;
        this.container.add(gameHeight, constraints);

        JButton done = new JButton("Done");
        done.addActionListener((e) -> this.Frame.dispose());
        done.setContentAreaFilled(false);
        done.setForeground(Main.Purple);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        this.container.add(done, constraints);

        this.container.setVisible(true);
    }

    private void update(ChangeEvent e, Boolean isWidth) {
        JSpinner Spinner = (JSpinner) e.getSource();
        if (isWidth)
            Main.gameWidth = (int) Spinner.getValue();
        else
            Main.gameHeight = (int) Spinner.getValue();
    }
}
