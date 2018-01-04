package com.yevhenpanko.jcontroller.ui;

import com.yevhenpanko.jcontroller.ui.icons.Icons;
import lombok.Getter;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.yevhenpanko.jcontroller.ui.Language.ENG;
import static com.yevhenpanko.jcontroller.ui.Language.UNIVERSAL;

@Getter
public enum Key {
    //first row
    VK_Q(0, 0, "grow", "q", KeyEvent.VK_Q, ENG),
    VK_W(0, 1, "grow", "w", KeyEvent.VK_W, ENG),
    VK_E(0, 2, "grow", "e", KeyEvent.VK_E, ENG),
    VK_R(0, 3, "grow", "r", KeyEvent.VK_R, ENG),
    VK_T(0, 4, "grow", "t", KeyEvent.VK_T, ENG),
    VK_Y(0, 5, "grow", "y", KeyEvent.VK_Y, ENG),
    VK_U(0, 6, "grow", "u", KeyEvent.VK_U, ENG),
    VK_I(0, 7, "grow", "i", KeyEvent.VK_I, ENG),
    VK_O(0, 8, "grow", "o", KeyEvent.VK_O, ENG),
    VK_P(0, 9, "grow", "p", KeyEvent.VK_P, ENG),
    VK_BACK_SPACE(0, 10, "wrap", "backspace", KeyEvent.VK_BACK_SPACE, UNIVERSAL),
    //second row
    VK_A(1, 0, "grow", "a", KeyEvent.VK_A, ENG),
    VK_S(1, 1, "grow", "s", KeyEvent.VK_S, ENG),
    VK_D(1, 2, "grow", "d", KeyEvent.VK_D, ENG),
    VK_F(1, 3, "grow", "f", KeyEvent.VK_F, ENG),
    VK_G(1, 4, "grow", "g", KeyEvent.VK_G, ENG),
    VK_H(1, 5, "grow", "h", KeyEvent.VK_H, ENG),
    VK_J(1, 6, "grow", "j", KeyEvent.VK_J, ENG),
    VK_K(1, 7, "grow", "k", KeyEvent.VK_K, ENG),
    VK_L(1, 8, "grow", "l", KeyEvent.VK_L, ENG),
    VK_ENTER(1, 9, "span, grow, wrap", "enter", KeyEvent.VK_ENTER, UNIVERSAL),
    //third row
    VK_SHIFT_LEFT(2, 0, "grow", "shift", KeyEvent.VK_SHIFT, UNIVERSAL),
    VK_Z(2, 1, "grow", "z", KeyEvent.VK_Z, ENG),
    VK_X(2, 2, "grow", "x", KeyEvent.VK_X, ENG),
    VK_C(2, 3, "grow", "c", KeyEvent.VK_C, ENG),
    VK_V(2, 4, "grow", "v", KeyEvent.VK_V, ENG),
    VK_B(2, 5, "grow", "b", KeyEvent.VK_B, ENG),
    VK_N(2, 6, "grow", "n", KeyEvent.VK_N, ENG),
    VK_M(2, 7, "grow", "m", KeyEvent.VK_M, ENG),
    VK_EXCLAMATION_MARK(2, 8, "grow", "!", KeyEvent.VK_EXCLAMATION_MARK, UNIVERSAL),
    VK_QUESTION_MARK(2, 9, "grow", "?", -1, UNIVERSAL),
    VK_SHIFT_RIGHT(2, 10, "grow, wrap", "shift", KeyEvent.VK_SHIFT, UNIVERSAL),
    //fourth row
    VK_NUM_LEFT(3, 0, "grow", "?123", -1, UNIVERSAL),
    VK_SLASH(3, 1, "grow", "/", KeyEvent.VK_SLASH, UNIVERSAL),
    VK_SPACE(3, 2, "span 6, grow", "space", KeyEvent.VK_SPACE, UNIVERSAL),
    VK_DOT_COM(3, 3, "grow", ".com", -1, UNIVERSAL),
    VK_DOT(3, 4, "grow", ".", -1, UNIVERSAL),
    VK_NUM_RIGHT(3, 5, "grow, wrap", "?123", -1, UNIVERSAL);

    private int row;
    private int col;
    private String layoutParams;
    private Object label;
    private int keyCode;
    private Language language;

    Key(int row, int col, String layoutParams, Object label, int keyCode, Language language) {
        this.row = row;
        this.col = col;
        this.layoutParams = layoutParams;
        this.label = label;
        this.keyCode = keyCode;
        this.language = language;
    }

    public static void main(String[] args) {
        String fonts[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
        }
    }
}
