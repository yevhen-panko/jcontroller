package com.yevhenpanko.jcontroller.ui;

import javax.swing.*;
import java.awt.*;

import static com.yevhenpanko.jcontroller.ui.UIConstants.BG_COLOR;

public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setUndecorated(true);
                frame.setBackground(BG_COLOR);
                frame.setLayout(new BorderLayout());
                frame.setFocusableWindowState(false);

                try {
                    frame.add(new EngKeyboard(), BorderLayout.SOUTH);
                } catch (AWTException e) {
                    e.printStackTrace();
                }

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
