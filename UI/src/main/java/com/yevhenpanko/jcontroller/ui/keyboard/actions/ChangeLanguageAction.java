package com.yevhenpanko.jcontroller.ui.keyboard.actions;

import com.yevhenpanko.jcontroller.ui.keyboard.VirtualKeyboard;

import java.awt.*;

import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_SHIFT;

public class ChangeLanguageAction implements Runnable {
    private VirtualKeyboard virtualKeyboard;
    private Robot robot;

    public ChangeLanguageAction(VirtualKeyboard virtualKeyboard, Robot robot) {
        this.virtualKeyboard = virtualKeyboard;
        this.robot = robot;
    }

    @Override
    public void run() {
        virtualKeyboard.changeLanguage();

        try {
            robot.keyPress(VK_CONTROL);
            robot.keyPress(VK_SHIFT);
        } finally {
            //to be sure that buttons will be released in any case
            robot.keyRelease(VK_CONTROL);
            robot.keyRelease(VK_SHIFT);
        }
    }
}
