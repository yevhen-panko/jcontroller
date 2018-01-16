package com.yevhenpanko.jcontroller.ui.keyboard.actions;

import java.awt.*;

import static java.awt.event.KeyEvent.VK_SHIFT;

public class ShiftPlusKeyAction implements Runnable {
    private Robot robot;
    private int keyCode;

    public ShiftPlusKeyAction(Robot robot, int keyCode) {
        this.robot = robot;
        this.keyCode = keyCode;
    }

    @Override
    public void run() {
        //do nothing if key code has been set as -1
        if (keyCode == -1){
            return;
        }

        try {
            robot.keyPress(VK_SHIFT);
            robot.keyPress(keyCode);
        } finally {
            //to be sure that buttons will be released in any case
            robot.keyRelease(keyCode);
            robot.keyRelease(VK_SHIFT);
        }
    }
}
