package com.yevhenpanko.jcontroller.ui.keyboard.actions;

import java.awt.*;

public class DefaultKeyAction implements Runnable {
    private Robot robot;
    private int[] keyCodes;

    public DefaultKeyAction(Robot robot, int... keyCodes) {
        this.robot = robot;
        this.keyCodes = keyCodes;
    }

    @Override
    public void run() {
        for (int keyCode : keyCodes) {
            //do nothing if key code has been set as -1
            if (keyCode == -1) {
                return;
            }

            try {
                robot.keyPress(keyCode);
            } finally {
                //to be sure that button will be released in any case
                robot.keyRelease(keyCode);
            }
        }
    }
}
