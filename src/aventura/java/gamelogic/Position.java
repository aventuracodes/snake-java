package aventura.java.gamelogic;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public static Position Copy(Position other) {
        return new Position(other.x, other.y);
    }

    public static Position randomPosition(int minX, int maxX, int minY, int maxY) {
        return new Position((int) (Math.random() * maxX) + minX + 1, (int) (Math.random() * maxY) + minY + 1);
    }

    public boolean equals(Position other) {
        return this.x == other.x & this.y == other.y;
    }
}
