package aventura.java.gamelogic;

import aventura.java.Main;

import javax.swing.*;
import java.awt.*;

public class GameBox {
    private final Position pos;
    private boolean isSnake;
    private boolean isGoal;
    private final JPanel box;

    public GameBox(int x, int y) {
        this.pos = new Position(x, y);
        this.box = new JPanel();
        this.box.setBackground(Color.BLACK);
        this.isSnake = false;
        this.isGoal = false;
    }

    public Position getPos() {
        return pos;
    }

    public JPanel getBox() {
        return this.box;
    }

    public boolean isGoal() {
        return isGoal;
    }

    public boolean isSnake() {
        return isSnake;
    }

    public void makeSnake(Boolean Josh) {
        if (Josh)
            this.box.setBackground(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        else
            this.box.setBackground(Main.SnakeColor);
        this.isSnake = true;
    }

    public void makeSnake() {
        this.box.setBackground(Main.SnakeColor);
        this.isSnake = true;
    }

    public void makeGoal() {
        this.box.setBackground(Main.Purple);
        this.isGoal = true;
    }

    public void makeNormal() {
        this.box.setBackground(Color.BLACK);
        this.isSnake = false;
        this.isGoal = false;
    }
}
