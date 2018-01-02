package com.yevhenpanko.jcontroller.services;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.awt.*;

import static java.awt.event.MouseEvent.BUTTON1_DOWN_MASK;
import static java.awt.event.MouseEvent.BUTTON3_DOWN_MASK;
import static java.lang.Math.*;
import static net.java.games.input.Controller.*;

public class BackgroundApplication {
    private static ApplicationConfig applicationConfig;

    private static Controller getController(Controller[] controllers, Type type){
        for (Controller controller : controllers) {
            if (controller.getType() == type){
                return controller;
            }
        }

        throw new RuntimeException("Can't find STICK controller.");
    }

    public static void main(String[] args) throws AWTException {
        applicationConfig = ApplicationConfig.getDefault();

        final Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        final Controller controller = getController(controllers, Type.STICK);

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

            if (abs(xValue) > applicationConfig.getTriggerOperatingThreshold()
                    || abs(yValue) > applicationConfig.getTriggerOperatingThreshold()) {
                System.out.println(String.format("%.3f", xValue) + " : " + String.format("%.3f", yValue));

                final Point p = MouseInfo.getPointerInfo().getLocation();
                int moveX = (int) (p.x + applicationConfig.getMouseMovingStepSize() * xValue);
                int moveY = (int) (p.y + applicationConfig.getMouseMovingStepSize() * yValue);

                robot.mouseMove(moveX, moveY);
            }

            xButtonPressed = doClick(robot, xButtonPressed, xButtonValue, BUTTON1_DOWN_MASK);
            optionsButtonPressed = doClick(robot, optionsButtonPressed, optionsButtonValue, BUTTON3_DOWN_MASK);

            try {
                Thread.sleep(applicationConfig.getInterrogationDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean doClick(Robot robot, boolean buttonPressed, float buttonValue, int buttonMask){
        if (buttonValue == 1){
            if (!buttonPressed) {
                System.out.println("Button pressed");
                robot.mousePress(buttonMask);
                buttonPressed = true;
            }
        } else {
            if (buttonPressed) {
                System.out.println("Button released");
                robot.mouseRelease(buttonMask);
                buttonPressed = false;
            }
        }

        return buttonPressed;
    }
}
