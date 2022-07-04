package aventura.java.gui;

import aventura.java.gamelogic.Game;
import aventura.java.gamelogic.Position;
import aventura.java.gamelogic.Snake;

public class Garry extends Game {
    public Garry(int width, int height, int snakeLength) {

        super(width, height);

        for (int rows = 0; rows < height; rows++) {
            for (int cols = 0; cols < width; cols++) {
                this.boxes[rows][cols].makeNormal();
            }
        }

        this.snake = new Snake(this, new Position(0, 0), snakeLength);
    }

    public void update() {
        Position headPos = this.snake.getHeadPos();
        if (headPos.equals(new Position(0, 0))) {
            this.snake.setCurrentDirection(Direction.East);
        } else if (headPos.equals(new Position(this.boxes[0].length - 1, 0))) {
            this.snake.setCurrentDirection(Direction.South);
        } else if (headPos.equals(new Position(this.boxes[0].length - 1, this.boxes.length - 1))) {
            this.snake.setCurrentDirection(Direction.West);
        } else if (headPos.equals(new Position(0, this.boxes.length - 1))) {
            this.snake.setCurrentDirection(Direction.North);
        }
        this.run();
    }
}
