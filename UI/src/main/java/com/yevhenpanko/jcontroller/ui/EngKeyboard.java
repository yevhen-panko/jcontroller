package com.yevhenpanko.jcontroller.ui;

import com.yevhenpanko.jcontroller.ui.icons.Icons;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EngKeyboard extends JPanel {
    private static final EmptyBorder EMPTY_BORDER = new EmptyBorder(0, 0, 0, 0);
    private static final Color BG_COLOR = new Color(64, 75, 81, 200);
    private static final Color FG_COLOR = new Color(159, 170, 172, 200);

    public EngKeyboard() {
        super();

        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        final Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

        int height = (int) (rect.getMaxY() / 3);
        int rowHeight = height / 4 - 10;
        final Dimension size = new Dimension((int) rect.getMaxX(), height);
        setPreferredSize(size);
        setBackground(BG_COLOR);
        setBorder(EMPTY_BORDER);

        final JPanel mainPanel = new JPanel(new MigLayout());
        mainPanel.setBackground(BG_COLOR);
        mainPanel.setBorder(EMPTY_BORDER);

        for (Key key : Key.values()) {
            final JButton button = new JButton();

            if (key.getLabel() instanceof Icons){
                button.setIcon(((Icons)key.getLabel()).getImageIcon());
            } else {
                button.setText((String) key.getLabel());
            }

            button.setFont(new Font(null, Font.ITALIC, 20));
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
        updateUI();
    }
}
