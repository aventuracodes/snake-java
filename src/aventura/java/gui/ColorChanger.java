package aventura.java.gui;

import aventura.java.Main;

import javax.swing.*;
import java.awt.*;

public class ColorChanger extends GuiBase {
    private final JPanel test;

    private final JSlider red;
    private final JSlider green;
    private final JSlider blue;

    private final JLabel redText;
    private final JLabel greenText;
    private final JLabel blueText;

    public ColorChanger(String name, int width, int height) {
        super(name, width, height);
        this.Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.Frame.setResizable(false);
        this.container.setLayout(new GridBagLayout());
        this.container.setVisible(false);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipady = 8;
        this.container.setBackground(Color.BLACK);

        this.red = new JSlider(0, 255, Main.SnakeColor.getRed());
        this.red.addChangeListener(e -> this.update());
        this.red.setMajorTickSpacing(50);
        this.red.setMinorTickSpacing(5);
        this.red.setPaintLabels(true);
        this.red.setForeground(Main.Purple);
        this.red.setBackground(Color.BLACK);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.ipadx = 110;
        this.container.add(this.red, constraints);

        this.redText = new JLabel("Red: " + this.red.getValue());
        this.redText.setFont(new Font(this.redText.getFont().getFontName(), Font.BOLD, 12));
        this.redText.setForeground(Main.Purple);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipadx = 10;
        this.container.add(this.redText, constraints);

        this.green = new JSlider(0, 255, Main.SnakeColor.getGreen());
        this.green.addChangeListener(e -> this.update());
        this.green.setMajorTickSpacing(50);
        this.green.setMinorTickSpacing(5);
        this.green.setPaintLabels(true);
        this.green.setForeground(Main.Purple);
        this.green.setBackground(Color.BLACK);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.ipadx = 110;
        this.container.add(this.green, constraints);

        this.greenText = new JLabel("Green: " + this.green.getValue());
        this.greenText.setFont(new Font(this.greenText.getFont().getFontName(), Font.BOLD, 12));
        this.greenText.setForeground(Main.Purple);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.ipadx = 10;
        this.container.add(this.greenText, constraints);

        this.blue = new JSlider(0, 255, Main.SnakeColor.getBlue());
        this.blue.addChangeListener(e -> this.update());
        this.blue.setMajorTickSpacing(50);
        this.blue.setMinorTickSpacing(5);
        this.blue.setPaintLabels(true);
        this.blue.setForeground(Main.Purple);
        this.blue.setBackground(Color.BLACK);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.ipadx = 110;
        this.container.add(this.blue, constraints);

        this.blueText = new JLabel("Blue: " + this.blue.getValue());
        this.blueText.setFont(new Font(this.blueText.getFont().getFontName(), Font.BOLD, 12));
        this.blueText.setForeground(Main.Purple);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.ipadx = 10;
        this.container.add(this.blueText, constraints);

        this.test = new JPanel();
        this.test.setBackground(new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue()));
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 3;
        constraints.ipadx = 110;
        this.container.add(this.test, constraints);

        JButton done = new JButton("Done");
        done.addActionListener((e) -> this.Frame.dispose());
        done.setContentAreaFilled(false);
        done.setForeground(Main.Purple);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        this.container.add(done, constraints);

        this.container.setVisible(true);
    }

    public void update() {
        Main.SnakeColor = new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue());

        this.test.setBackground(new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue()));
        this.test.repaint();

        this.redText.setText("Red: " + this.red.getValue());
        this.redText.repaint();

        this.greenText.setText("Green: " + this.green.getValue());
        this.greenText.repaint();

        this.blueText.setText("Blue: " + this.blue.getValue());
        this.blueText.repaint();
    }
}
