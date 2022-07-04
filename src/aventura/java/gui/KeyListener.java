package aventura.java.gui;

import aventura.java.gamelogic.Game;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {

    private final Game game;

    KeyListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP, KeyEvent.VK_W -> this.game.setSnakeDirection(Game.Direction.North);
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> this.game.setSnakeDirection(Game.Direction.West);
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> this.game.setSnakeDirection(Game.Direction.South);
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> this.game.setSnakeDirection(Game.Direction.East);
            case KeyEvent.VK_R -> this.game.getSnake().rainbow();
            case KeyEvent.VK_SPACE -> this.game.pause();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
