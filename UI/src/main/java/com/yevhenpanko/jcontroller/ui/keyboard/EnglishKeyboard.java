package com.yevhenpanko.jcontroller.ui.keyboard;

import com.yevhenpanko.jcontroller.ui.keyboard.actions.ChangeLanguageAction;
import com.yevhenpanko.jcontroller.ui.keyboard.actions.DefaultKeyAction;
import com.yevhenpanko.jcontroller.ui.keyboard.actions.ShiftPlusKeyAction;
import com.yevhenpanko.jcontroller.ui.keyboard.actions.ShowNumericKeyboardAction;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.yevhenpanko.jcontroller.ui.icons.Icons.*;
import static java.awt.event.KeyEvent.*;

@Getter
public class EnglishKeyboard {
    private List<VirtualKey> keys;

    public EnglishKeyboard(Robot robot) {
        this.keys = new ArrayList<>();

        //first row
        this.keys.add(new VirtualKey("q", "grow", new DefaultKeyAction(robot, VK_Q)));
        this.keys.add(new VirtualKey("w", "grow", new DefaultKeyAction(robot, VK_W)));
        this.keys.add(new VirtualKey("e", "grow", new DefaultKeyAction(robot, VK_E)));
        this.keys.add(new VirtualKey("r", "grow", new DefaultKeyAction(robot, VK_R)));
        this.keys.add(new VirtualKey("t", "grow", new DefaultKeyAction(robot, VK_T)));
        this.keys.add(new VirtualKey("y", "grow", new DefaultKeyAction(robot, VK_Y)));
        this.keys.add(new VirtualKey("u", "grow", new DefaultKeyAction(robot, VK_U)));
        this.keys.add(new VirtualKey("i", "grow", new DefaultKeyAction(robot, VK_I)));
        this.keys.add(new VirtualKey("o", "grow", new DefaultKeyAction(robot, VK_O)));
        this.keys.add(new VirtualKey("p", "grow", new DefaultKeyAction(robot, VK_P)));
        this.keys.add(new VirtualKey(BACKSPACE, "wrap", new DefaultKeyAction(robot, VK_BACK_SPACE)));
        //second row
        this.keys.add(new VirtualKey("a", "grow", new DefaultKeyAction(robot, VK_A)));
        this.keys.add(new VirtualKey("s", "grow", new DefaultKeyAction(robot, VK_S)));
        this.keys.add(new VirtualKey("d", "grow", new DefaultKeyAction(robot, VK_D)));
        this.keys.add(new VirtualKey("f", "grow", new DefaultKeyAction(robot, VK_F)));
        this.keys.add(new VirtualKey("g", "grow", new DefaultKeyAction(robot, VK_G)));
        this.keys.add(new VirtualKey("h", "grow", new DefaultKeyAction(robot, VK_H)));
        this.keys.add(new VirtualKey("j", "grow", new DefaultKeyAction(robot, VK_J)));
        this.keys.add(new VirtualKey("k", "grow", new DefaultKeyAction(robot, VK_K)));
        this.keys.add(new VirtualKey("l", "grow", new DefaultKeyAction(robot, VK_L)));
        this.keys.add(new VirtualKey(ENTER, "span, grow, wrap", new DefaultKeyAction(robot, VK_ENTER)));
        //third row
        this.keys.add(new VirtualKey(SHIFT, "grow", new DefaultKeyAction(robot, VK_SHIFT)));
        this.keys.add(new VirtualKey("z", "grow", new DefaultKeyAction(robot, VK_Z)));
        this.keys.add(new VirtualKey("x", "grow", new DefaultKeyAction(robot, VK_X)));
        this.keys.add(new VirtualKey("c", "grow", new DefaultKeyAction(robot, VK_C)));
        this.keys.add(new VirtualKey("v", "grow", new DefaultKeyAction(robot, VK_V)));
        this.keys.add(new VirtualKey("b", "grow", new DefaultKeyAction(robot, VK_B)));
        this.keys.add(new VirtualKey("n", "grow", new DefaultKeyAction(robot, VK_N)));
        this.keys.add(new VirtualKey("m", "grow", new DefaultKeyAction(robot, VK_M)));
        this.keys.add(new VirtualKey("!", "grow", new ShiftPlusKeyAction(robot, VK_1)));
        this.keys.add(new VirtualKey("?", "grow", new ShiftPlusKeyAction(robot, VK_SLASH)));
        this.keys.add(new VirtualKey(SHIFT, "grow, wrap", new DefaultKeyAction(robot, VK_SHIFT)));
        //fourth row
        this.keys.add(new VirtualKey("?123", "grow", new ShowNumericKeyboardAction(robot)));
        this.keys.add(new VirtualKey("/", "grow", new DefaultKeyAction(robot, VK_SLASH)));
        this.keys.add(new VirtualKey(LANGUAGE, "grow", new ChangeLanguageAction(robot)));
        this.keys.add(new VirtualKey("space", "span 5, grow", new DefaultKeyAction(robot, VK_SPACE)));
        this.keys.add(new VirtualKey(".com", "grow", new DefaultKeyAction(robot, VK_PERIOD, VK_C, VK_O, VK_M)));
        this.keys.add(new VirtualKey(".", "grow", new DefaultKeyAction(robot, VK_PERIOD)));
        this.keys.add(new VirtualKey("?123", "grow, wrap", new ShowNumericKeyboardAction(robot)));
    }
}
