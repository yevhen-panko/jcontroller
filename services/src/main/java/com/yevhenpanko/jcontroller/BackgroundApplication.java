package com.yevhenpanko.jcontroller;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.awt.*;

import static java.awt.event.MouseEvent.BUTTON1_DOWN_MASK;
import static java.awt.event.MouseEvent.BUTTON3_DOWN_MASK;

public class BackgroundApplication {
    private static final double THRESHOLD = 0.2;
    private static final double STEP_SIZE = 10;

    public static void main(String[] args) throws AWTException {
        final Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

        final Controller controller = controllers[6];
        final Robot robot = new Robot();
        boolean xButtonPressed = false;
        boolean optionsButtonPressed = false;

        while (true) {
            controller.poll();

            final Component xAxis = controller.getComponent(Component.Identifier.Axis.X);
            final Component yAxis = controller.getComponent(Component.Identifier.Axis.Y);
            final Component xButton = controller.getComponent(Component.Identifier.Button._1);
            final Component optionsButton = controller.getComponent(Component.Identifier.Button._9);

            float xValue = xAxis.getPollData();
            float yValue = yAxis.getPollData();
            float xButtonValue = xButton.getPollData();
            float optionsButtonValue = optionsButton.getPollData();

            if (Math.abs(xValue) > THRESHOLD || Math.abs(yValue) > THRESHOLD) {
                System.out.println(String.format("%.3f", xValue) + " : " + String.format("%.3f", yValue));

                final Point p = MouseInfo.getPointerInfo().getLocation();
                int moveX = (int) (p.x + STEP_SIZE * xValue);
                int moveY = (int) (p.y + STEP_SIZE * yValue); // y axis is inversed -1 is on top

                robot.mouseMove(moveX, moveY);
            }

            xButtonPressed = doClick(robot, xButtonPressed, xButtonValue, BUTTON1_DOWN_MASK);
            optionsButtonPressed = doClick(robot, optionsButtonPressed, optionsButtonValue, BUTTON3_DOWN_MASK);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean doClick(Robot robot, boolean buttonPressed, float buttonValue, int buttonMask){
        if (buttonValue == 1){
            if (!buttonPressed) {
                robot.mousePress(buttonMask);
                robot.mouseRelease(buttonMask);
                buttonPressed = true;
            }
        } else {
            buttonPressed = false;
        }

        return buttonPressed;
    }
}
