package aventura.java.gamelogic;

import java.util.ArrayList;

public class Snake {
    private final ArrayList<GameBox> parts;
    protected GameBox head;
    protected Game game;
    private Game.Direction currentDirection;
    private boolean isAlive;
    private boolean isJosh;
    private int length;

    public Snake(Game game) {
        this.currentDirection = Game.Direction.East;
        this.length = 0;
        this.game = game;
        this.isAlive = true;
        this.isJosh = false;
        this.head = this.game.getBoxFromPos(new Position(this.game.getBoxes()[0].length / 2, this.game.getBoxes().length / 2));
        this.head.makeSnake();
        this.parts = new ArrayList<>();
        this.parts.add(this.head);
    }

    public Snake(Game game, Position pos, int length) {
        this.currentDirection = Game.Direction.East;
        this.length = length;
        this.game = game;
        this.isAlive = true;
        this.isJosh = false;
        this.head = this.game.getBoxFromPos(pos);
        this.head.makeSnake();
        this.parts = new ArrayList<>();
        this.parts.add(this.head);
    }

    public void setDead() {
        isAlive = false;
    }

    public void move() {
        if (!this.isAlive)
            return;
        GameBox futureBox = this.getNextBox();
        if (futureBox == null || futureBox.isSnake()) {
            this.setDead();
            return;
        }

        boolean metGoal = false;

        if (futureBox.isGoal()) {
            this.game.addToScore();
            futureBox.makeNormal();
            metGoal = true;
        }

        futureBox.makeSnake(this.isJosh);
        this.parts.add(0, futureBox);
        this.head = futureBox;
        if (!metGoal && this.length == 0) {
            this.parts.get(this.parts.size() - 1).makeNormal();
            this.parts.remove(this.parts.size() - 1);
        } else {
            if (this.length != 0)
                this.length--;
            else
                this.game.setNewGoal();
        }
    }

    public void rainbow() {
        isJosh = !isJosh;
    }

    private GameBox getNextBox() {
        Position futurePos = Position.Copy(this.head.getPos());
        switch (this.currentDirection) {
            case North -> futurePos.add(0, -1);
            case South -> futurePos.add(0, 1);
            case East -> futurePos.add(1, 0);
            case West -> futurePos.add(-1, 0);
        }

        if (futurePos.x < 0 || futurePos.x >= this.game.getBoxes()[0].length || futurePos.y < 0 || futurePos.y >= this.game.getBoxes().length) {
            return null;
        }
        return this.game.getBoxFromPos(futurePos);
    }

    public boolean getIsSnakeAlive() {
        return this.isAlive;
    }

    public void setCurrentDirection(Game.Direction direction) {
        Game.Direction oldDirection = this.currentDirection;
        this.currentDirection = direction;
        if (this.parts.size() > 1) {
            if (this.getNextBox() != null && this.getNextBox().getPos().equals(this.parts.get(1).getPos())) {
                this.currentDirection = oldDirection;
            }
        }
    }

    public Position getHeadPos() {
        return this.head.getPos();
    }
}
