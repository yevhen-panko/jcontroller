package com.yevhenpanko.jcontroller.ui.keyboard.impl;

import com.yevhenpanko.jcontroller.ui.keyboard.VirtualKey;
import com.yevhenpanko.jcontroller.ui.keyboard.VirtualKeyboard;
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
public class RusKeyboard {
    private List<VirtualKey> keys;

    public RusKeyboard(VirtualKeyboard virtualKeyboard, Robot robot) {
        this.keys = new ArrayList<>();

        //first row
        this.keys.add(new VirtualKey("й", "grow", new DefaultKeyAction(robot, VK_Q)));
        this.keys.add(new VirtualKey("ц", "grow", new DefaultKeyAction(robot, VK_W)));
        this.keys.add(new VirtualKey("у", "grow", new DefaultKeyAction(robot, VK_E)));
        this.keys.add(new VirtualKey("к", "grow", new DefaultKeyAction(robot, VK_R)));
        this.keys.add(new VirtualKey("е", "grow", new DefaultKeyAction(robot, VK_T)));
        this.keys.add(new VirtualKey("н", "grow", new DefaultKeyAction(robot, VK_Y)));
        this.keys.add(new VirtualKey("г", "grow", new DefaultKeyAction(robot, VK_U)));
        this.keys.add(new VirtualKey("ш", "grow", new DefaultKeyAction(robot, VK_I)));
        this.keys.add(new VirtualKey("щ", "grow", new DefaultKeyAction(robot, VK_O)));
        this.keys.add(new VirtualKey("з", "grow", new DefaultKeyAction(robot, VK_P)));
        this.keys.add(new VirtualKey("х", "grow", new DefaultKeyAction(robot, VK_OPEN_BRACKET)));
        this.keys.add(new VirtualKey("ъ", "grow", new DefaultKeyAction(robot, VK_CLOSE_BRACKET)));
        this.keys.add(new VirtualKey(BACKSPACE, "wrap", new DefaultKeyAction(robot, VK_BACK_SPACE)));
        //second row
        this.keys.add(new VirtualKey("ф", "grow", new DefaultKeyAction(robot, VK_A)));
        this.keys.add(new VirtualKey("ы", "grow", new DefaultKeyAction(robot, VK_S)));
        this.keys.add(new VirtualKey("в", "grow", new DefaultKeyAction(robot, VK_D)));
        this.keys.add(new VirtualKey("а", "grow", new DefaultKeyAction(robot, VK_F)));
        this.keys.add(new VirtualKey("п", "grow", new DefaultKeyAction(robot, VK_G)));
        this.keys.add(new VirtualKey("р", "grow", new DefaultKeyAction(robot, VK_H)));
        this.keys.add(new VirtualKey("о", "grow", new DefaultKeyAction(robot, VK_J)));
        this.keys.add(new VirtualKey("л", "grow", new DefaultKeyAction(robot, VK_K)));
        this.keys.add(new VirtualKey("д", "grow", new DefaultKeyAction(robot, VK_L)));
        this.keys.add(new VirtualKey("ж", "grow", new DefaultKeyAction(robot, VK_SEMICOLON)));
        this.keys.add(new VirtualKey("э", "grow", new DefaultKeyAction(robot, VK_QUOTE)));
        this.keys.add(new VirtualKey(ENTER, "span, grow, wrap", new DefaultKeyAction(robot, VK_ENTER)));
        //third row
        this.keys.add(new VirtualKey(SHIFT, "grow", new DefaultKeyAction(robot, VK_SHIFT)));
        this.keys.add(new VirtualKey("я", "grow", new DefaultKeyAction(robot, VK_Z)));
        this.keys.add(new VirtualKey("ч", "grow", new DefaultKeyAction(robot, VK_X)));
        this.keys.add(new VirtualKey("с", "grow", new DefaultKeyAction(robot, VK_C)));
        this.keys.add(new VirtualKey("м", "grow", new DefaultKeyAction(robot, VK_V)));
        this.keys.add(new VirtualKey("и", "grow", new DefaultKeyAction(robot, VK_B)));
        this.keys.add(new VirtualKey("т", "grow", new DefaultKeyAction(robot, VK_N)));
        this.keys.add(new VirtualKey("ь", "grow", new DefaultKeyAction(robot, VK_M)));
        this.keys.add(new VirtualKey("б", "grow", new DefaultKeyAction(robot, VK_LESS)));
        this.keys.add(new VirtualKey("ю", "grow", new DefaultKeyAction(robot, VK_GREATER)));
        this.keys.add(new VirtualKey(SHIFT, "grow, span 3, wrap", new DefaultKeyAction(robot, VK_SHIFT)));
        //fourth row
        this.keys.add(new VirtualKey("?123", "grow", new ShowNumericKeyboardAction(robot)));
        this.keys.add(new VirtualKey("/", "grow", new DefaultKeyAction(robot, VK_SLASH)));
        this.keys.add(new VirtualKey(LANGUAGE, "grow", new ChangeLanguageAction(virtualKeyboard, robot)));
        this.keys.add(new VirtualKey("space", "span 7, grow", new DefaultKeyAction(robot, VK_SPACE)));
        this.keys.add(new VirtualKey(".com", "grow", new DefaultKeyAction(robot, VK_PERIOD, VK_C, VK_O, VK_M)));
        this.keys.add(new VirtualKey(".", "grow", new DefaultKeyAction(robot, VK_PERIOD)));
        this.keys.add(new VirtualKey("?123", "grow, wrap", new ShowNumericKeyboardAction(robot)));
    }
}
