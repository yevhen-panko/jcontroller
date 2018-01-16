package com.yevhenpanko.jcontroller.ui.keyboard;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.yevhenpanko.jcontroller.ui.UIConstants.*;

public class VirtualKeyboard extends JFrame {
    private final Robot robot;
    private final java.util.List<JButton> buttons;

    public VirtualKeyboard() throws AWTException {
        super("Virtual Keyboard");

        this.robot = new Robot();
        this.buttons = new ArrayList<>();

        setUndecorated(true);
        setBackground(BG_COLOR);
        setLayout(new BorderLayout());
        setFocusableWindowState(false);

        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        final Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

        int height = (int) (rect.getMaxY() / 3);
        int rowHeight = height / 4 - 10;
        final Dimension size = new Dimension((int) rect.getMaxX(), height);

        add(createContent(rowHeight, size));
        pack();

        int x = (int) rect.getMaxX() - getWidth();
        int y = (int) rect.getMaxY() - getHeight();

        setLocation(x, y);
        setAlwaysOnTop(true);
    }

    private JComponent createContent(int rowHeight, Dimension size) {
        final JPanel contentPanel = new JPanel();
        contentPanel.setBackground(TRANSPARENT_BG_COLOR);
        contentPanel.setBorder(NO_BORDER);
        contentPanel.setPreferredSize(size);

        final JPanel buttonsPanel = new JPanel(new MigLayout());
        buttonsPanel.setBackground(TRANSPARENT_BG_COLOR);
        buttonsPanel.setBorder(NO_BORDER);

        final EnglishKeyboard englishKeyboard = new EnglishKeyboard(robot);
        final List<VirtualKey> keys = englishKeyboard.getKeys();

        for (VirtualKey key : keys) {
            final JButton button = new JButton();
            buttons.add(button);

            if (key.getLabel() != null) {
                button.setText(key.getLabel());
            }

            if (key.getIcon() != null) {
                button.setIcon((key.getIcon()).getImageIcon());
            }

            button.addActionListener(e -> {
                key.getAction().run();
            });

            button.setFont(DEFAULT_FONT);
            button.setBackground(BG_COLOR);
            button.setForeground(FG_COLOR);
            button.setFocusable(false);

            if (button.getText().length() == 1) {
                buttonsPanel.add(button, key.getLayoutParams() + ", h " + rowHeight + ", w " + rowHeight);
            } else {
                buttonsPanel.add(button, key.getLayoutParams() + ", h " + rowHeight);
            }
        }

        contentPanel.add(buttonsPanel);

        return contentPanel;
    }
}
