package com.yevhenpanko.jcontroller.ui;

import com.yevhenpanko.jcontroller.ui.icons.Icons;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.yevhenpanko.jcontroller.ui.UIConstants.*;

public class EngKeyboard extends JPanel {
    private final Robot robot;
    private final java.util.List<JButton> buttons;

    public EngKeyboard() throws AWTException {
        super();

        this.robot = new Robot();
        this.buttons = new ArrayList<>();

        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        final Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

        int height = (int) (rect.getMaxY() / 3);
        int rowHeight = height / 4 - 10;
        final Dimension size = new Dimension((int) rect.getMaxX(), height);
        setPreferredSize(size);
        setBackground(TRANSPARENT_BG_COLOR);
        setBorder(NO_BORDER);

        final JPanel mainPanel = new JPanel(new MigLayout());
        mainPanel.setBackground(TRANSPARENT_BG_COLOR);
        mainPanel.setBorder(NO_BORDER);

        for (Key key : Key.values()) {
            final JButton button = new JButton();
            buttons.add(button);

            if (key.getLabel() instanceof Icons) {
                button.setIcon(((Icons) key.getLabel()).getImageIcon());
            } else {
                button.setText((String) key.getLabel());
            }

            button.addActionListener(e -> {
                int keyCode = key.getKeyCode();
                if (keyCode != -1) {
                    robot.keyPress(keyCode);
                    robot.keyRelease(keyCode);
                }
            });

            button.setFont(DEFAULT_FONT);
            button.setBackground(BG_COLOR);
            button.setForeground(FG_COLOR);
            button.setFocusable(false);

            if (button.getText().length() == 1) {
                mainPanel.add(button, key.getLayoutParams() + ", h " + rowHeight + ", w " + rowHeight);
            } else {
                mainPanel.add(button, key.getLayoutParams() + ", h " + rowHeight);
            }
        }

        add(mainPanel);
    }
}
