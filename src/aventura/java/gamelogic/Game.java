package aventura.java.gamelogic;

import javax.swing.*;
import java.awt.*;

public class Game {
    public enum Direction {
        North, South, East, West
    }

    protected Snake snake;
    protected GameBox[][] boxes;
    private JPanel gamePanel;
    private int score;
    private boolean gamePaused;
    private Position goalPos;

    public Game(int width, int height) {

        this.boxes = new GameBox[height][width];
        for (int rows = 0; rows < height; rows++) {
            for (int cols = 0; cols < width; cols++) {
                this.boxes[rows][cols] = new GameBox(cols, rows);
            }
        }

        this.snake = new Snake(this);

        this.setup(width, height);
    }

    private void setup(int width, int height) {
        this.score = 0;
        this.gamePaused = false;

        this.goalPos = new Position(0, 0);
        this.setNewGoal();
        this.getBoxFromPos(this.goalPos).makeGoal();

        this.gamePanel = new JPanel(new GridLayout(height, width));
        this.gamePanel.setBackground(Color.BLACK);
        this.gamePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        for (GameBox[] boxes : this.boxes) {
            for (GameBox box : boxes) {
                this.gamePanel.add(box.getBox());
            }
        }
    }

    public JPanel getGamePanel() {
        return this.gamePanel;
    }

    public GameBox[][] getBoxes() {
        return this.boxes;
    }

    public void setNewGoal() {
        Position pos = Position.randomPosition(0, this.boxes[0].length - 1, 0, this.boxes.length - 1);
        while (this.getBoxFromPos(pos).isGoal() || this.getBoxFromPos(pos).isSnake()) {
            pos = Position.randomPosition(0, this.boxes[0].length - 1, 0, this.boxes.length - 1);
        }
        this.goalPos = pos;
        this.getBoxFromPos(this.goalPos).makeGoal();
    }

    public int getScore() {
        return score;
    }

    public void addToScore() {
        this.score++;
    }

    public void run() {
        if (!this.gamePaused) {
            this.snake.move();
        }
    }

    public void pause() {
        this.gamePaused = !this.gamePaused;
    }

    public GameBox getBoxFromPos(Position pos) {
        return this.boxes[pos.y][pos.x];
    }

    public Snake getSnake() {
        return this.snake;
    }

    public void setSnakeDirection(Direction direction) {
        if (!this.gamePaused) {
            this.snake.setCurrentDirection(direction);
        }
    }
}
