package aventura.java;

import aventura.java.gui.GameGui;
import aventura.java.gui.Menu;

import java.awt.*;

public class Main {
    public static Color Purple = new Color(90, 5, 140);
    public static Color SnakeColor = Color.WHITE;
    public static int gameWidth = 32;
    public static int gameHeight = 32;

    public static void main(String[] args) {
        Main.startGameMenu();
    }

    public static void startGameMenu() {
        new Menu();
    }

    public static void startGame() {
        new GameGui("Snake", Main.gameWidth * 16, Main.gameHeight * 16 + 70, Main.gameWidth, Main.gameHeight);
    }
}
