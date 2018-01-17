package com.yevhenpanko.jcontroller.ui.keyboard;

import com.yevhenpanko.jcontroller.services.keyboard.KeyboardLayout;
import com.yevhenpanko.jcontroller.services.keyboard.KeyboardSystemService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.yevhenpanko.jcontroller.ui.UIConstants.*;
import static com.yevhenpanko.jcontroller.ui.keyboard.KeyboardType.ENG;
import static com.yevhenpanko.jcontroller.ui.keyboard.KeyboardType.RUS;

public class VirtualKeyboard extends JFrame {
    private final Robot robot;
    private final java.util.List<JButton> buttons;
    private final Dimension size;
    private final int rowHeight;
    private JPanel boardsPanel;

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

        size = new Dimension((int) rect.getMaxX(), height);
        rowHeight = height / 4 - 10;

        add(createContent());
        pack();

        int x = (int) rect.getMaxX() - getWidth();
        int y = (int) rect.getMaxY() - getHeight();

        setLocation(x, y);
        setAlwaysOnTop(true);
    }

    public void showLayer(KeyboardType keyboardType) {
        final CardLayout cardLayout = (CardLayout) boardsPanel.getLayout();
        cardLayout.show(boardsPanel, keyboardType.name());

        this.repaint();
    }

    public void changeLanguage(){
        final Optional<KeyboardLayout> keyboardLayout = new KeyboardSystemService().getKeyboardLayout();

        if (keyboardLayout.isPresent()) {
            switch (keyboardLayout.get()) {
                case ENG:
                default:
                    showLayer(KeyboardType.RUS);
                    break;
                case RUS:
                    showLayer(KeyboardType.ENG);
                    break;
            }
        }
    }

    @Override
    public void setVisible(boolean b) {
        final Optional<KeyboardLayout> keyboardLayout = new KeyboardSystemService().getKeyboardLayout();

        if (keyboardLayout.isPresent()) {
            switch (keyboardLayout.get()) {
                case ENG:
                default:
                    showLayer(KeyboardType.ENG);
                    break;
                case RUS:
                    showLayer(KeyboardType.RUS);
                    break;
            }
        }

        super.setVisible(b);
    }

    private JComponent createContent() {
        final JPanel contentPanel = new JPanel();
        contentPanel.setBackground(TRANSPARENT_BG_COLOR);
        contentPanel.setBorder(NO_BORDER);
        contentPanel.setPreferredSize(size);

        boardsPanel = new JPanel();
        boardsPanel.setLayout(new CardLayout());
        boardsPanel.setBackground(TRANSPARENT_BG_COLOR);
        boardsPanel.setBorder(NO_BORDER);

        final EngKeyboard engKeyboard = new EngKeyboard(this, robot);
        boardsPanel.add(createButtonPanel(engKeyboard.getKeys()), ENG.name());

        final RusKeyboard rusKeyboard = new RusKeyboard(this, robot);
        boardsPanel.add(createButtonPanel(rusKeyboard.getKeys()), RUS.name());

        contentPanel.add(boardsPanel);

        return contentPanel;
    }

    private JPanel createButtonPanel(List<VirtualKey> keys) {
        final JPanel buttonsPanel = new JPanel(new MigLayout());
        buttonsPanel.setBackground(TRANSPARENT_BG_COLOR);
        buttonsPanel.setBorder(NO_BORDER);

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

        return buttonsPanel;
    }
}
