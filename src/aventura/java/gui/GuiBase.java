package aventura.java.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class GuiBase {
    protected JFrame Frame;
    protected Container container;

    protected GuiBase(String name, int width, int height) {
        this.Frame = new JFrame(name);
        this.Frame.setSize(width, height);
        int y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (height / 2);
        if (y < 0)
            y = 0;
        this.Frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (width / 2), y);
        this.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.Frame.setVisible(true);
        this.container = this.Frame.getContentPane();
        this.setIcon();
    }

    private void setIcon() {
        try {
            InputStream icon = this.getClass().getClassLoader().getResourceAsStream("SnakeIcon.png");
            BufferedImage iconImage = ImageIO.read(icon);
            this.Frame.setIconImage(iconImage);
        } catch (Exception e) {
            System.out.println("Icon Not Found");
        }
    }
}
