package com.yevhenpanko.jcontroller.ui.keyboard;

import com.yevhenpanko.jcontroller.ui.icons.Icons;
import lombok.Getter;

import java.awt.event.KeyEvent;

import static com.yevhenpanko.jcontroller.ui.keyboard.Language.ENG;
import static com.yevhenpanko.jcontroller.ui.keyboard.Language.UNIVERSAL;

@Getter
public enum Key {
    //first row
    VK_Q("q", ENG, "grow", false, KeyEvent.VK_Q),
    VK_W("w", ENG, "grow", false, KeyEvent.VK_W),
    VK_E("e", ENG, "grow", false, KeyEvent.VK_E),
    VK_R("r", ENG, "grow", false, KeyEvent.VK_R),
    VK_T("t", ENG, "grow", false, KeyEvent.VK_T),
    VK_Y("y", ENG, "grow", false, KeyEvent.VK_Y),
    VK_U("u", ENG, "grow", false, KeyEvent.VK_U),
    VK_I("i", ENG, "grow", false, KeyEvent.VK_I),
    VK_O("o", ENG, "grow", false, KeyEvent.VK_O),
    VK_P("p", ENG, "grow", false, KeyEvent.VK_P),
    VK_BACK_SPACE(Icons.BACKSPACE, UNIVERSAL, "wrap", false, KeyEvent.VK_BACK_SPACE),
    //second row
    VK_A("a", ENG, "grow", false, KeyEvent.VK_A),
    VK_S("s", ENG, "grow", false, KeyEvent.VK_S),
    VK_D("d", ENG, "grow", false, KeyEvent.VK_D),
    VK_F("f", ENG, "grow", false, KeyEvent.VK_F),
    VK_G("g", ENG, "grow", false, KeyEvent.VK_G),
    VK_H("h", ENG, "grow", false, KeyEvent.VK_H),
    VK_J("j", ENG, "grow", false, KeyEvent.VK_J),
    VK_K("k", ENG, "grow", false, KeyEvent.VK_K),
    VK_L("l", ENG, "grow", false, KeyEvent.VK_L),
    VK_ENTER(Icons.ENTER, UNIVERSAL, "span, grow, wrap", false, KeyEvent.VK_ENTER),
    //third row
    VK_SHIFT_LEFT(Icons.SHIFT, UNIVERSAL, "grow", false, KeyEvent.VK_SHIFT),
    VK_Z("z", ENG, "grow", false, KeyEvent.VK_Z),
    VK_X("x", ENG, "grow", false, KeyEvent.VK_X),
    VK_C("c", ENG, "grow", false, KeyEvent.VK_C),
    VK_V("v", ENG, "grow", false, KeyEvent.VK_V),
    VK_B("b", ENG, "grow", false, KeyEvent.VK_B),
    VK_N("n", ENG, "grow", false, KeyEvent.VK_N),
    VK_M("m", ENG, "grow", false, KeyEvent.VK_M),
    VK_EXCLAMATION_MARK("!", UNIVERSAL, "grow", true, KeyEvent.VK_1),
    VK_QUESTION_MARK("?", UNIVERSAL, "grow", true, KeyEvent.VK_SLASH),
    VK_SHIFT_RIGHT(Icons.SHIFT, UNIVERSAL, "grow, wrap", false, KeyEvent.VK_SHIFT),
    //fourth row
    VK_NUM_LEFT("?123", UNIVERSAL, "grow", false, -1),
    VK_SLASH("/", UNIVERSAL, "grow", false, KeyEvent.VK_SLASH),
    VK_SPACE("space", UNIVERSAL, "span 6, grow", false, KeyEvent.VK_SPACE),
    VK_DOT_COM(".com", UNIVERSAL, "grow", false, KeyEvent.VK_PERIOD, KeyEvent.VK_C, KeyEvent.VK_O, KeyEvent.VK_M),
    VK_DOT(".", UNIVERSAL, "grow", false, KeyEvent.VK_PERIOD),
    VK_NUM_RIGHT("?123", UNIVERSAL, "grow, wrap", false, -1);

    private Object label;
    private Language language;
    private String layoutParams;
    private boolean shiftRequired;
    private int[] keyCodes;

    Key(Object label, Language language, String layoutParams, boolean shiftRequired, int... keyCodes) {
        this.label = label;
        this.language = language;
        this.layoutParams = layoutParams;
        this.shiftRequired = shiftRequired;
        this.keyCodes = keyCodes;
    }
}
