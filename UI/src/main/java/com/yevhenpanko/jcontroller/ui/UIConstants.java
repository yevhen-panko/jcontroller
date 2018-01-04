package com.yevhenpanko.jcontroller.ui;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface UIConstants {
    Border NO_BORDER = new EmptyBorder(0, 0, 0, 0);
    Color BG_COLOR = new Color(64, 75, 81, 240);
    Color TRANSPARENT_BG_COLOR = new Color(0, 0, 0, 0);
    Color FG_COLOR = new Color(159, 170, 172, 200);
    Font DEFAULT_FONT = new Font("Monospaced", Font.BOLD, 24);
}
