package com.yevhenpanko.jcontroller.ui;

import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setUndecorated(true);
                frame.setBackground(new Color(39, 50, 56, 200));
                frame.setLayout(new BorderLayout());
                frame.add(new EngKeyboard(), BorderLayout.SOUTH);
                frame.pack();

                final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                final GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
                final Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
                int x = (int) rect.getMaxX() - frame.getWidth();
                int y = (int) rect.getMaxY() - frame.getHeight();

                frame.setLocation(x, y);
                frame.setAlwaysOnTop(true);
                frame.setVisible(true);
            }
        });
    }
}
