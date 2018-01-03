package com.yevhenpanko.jcontroller.services.eventsprovider;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.model.events.impl.ButtonPressedEvent;
import com.yevhenpanko.jcontroller.model.events.impl.ButtonReleasedEvent;
import com.yevhenpanko.jcontroller.model.events.impl.StickMovedHorizontallyEvent;
import com.yevhenpanko.jcontroller.model.events.impl.StickMovedVerticallyEvent;
import com.yevhenpanko.jcontroller.model.identification.IdentifierMapper;
import com.yevhenpanko.jcontroller.model.identification.PS4DualShockMapper;
import com.yevhenpanko.jcontroller.model.notification.NotificationStatus;
import com.yevhenpanko.jcontroller.services.observer.Observer;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.HashMap;
import java.util.Map;

import static com.yevhenpanko.jcontroller.model.events.EventType.*;
import static com.yevhenpanko.jcontroller.model.notification.NotificationStatus.*;
import static java.lang.Math.abs;

public class JInputEventsProvider implements EventsProvider {
    private final Map<EventDetails, Observer> observersMap;
    private final ApplicationConfig applicationConfig;
    private final IdentifierMapper identifierMapper;

    private NotificationStatus notificationStatus = NOT_STARTED;

    public JInputEventsProvider() {
        this.observersMap = new HashMap<>();
        this.applicationConfig = ApplicationConfig.getDefault();
        this.identifierMapper = new PS4DualShockMapper();
    }

    @Override
    public void register(Observer observer) {
        for (EventDetails eventDetails : observer.listenFor()) {
            observersMap.put(eventDetails, observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observersMap.remove(observer.listenFor());
    }

    @Override
    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    @Override
    public void startNotification() {
        notificationStatus = STARTED;
    }

    @Override
    public void pauseNotification() {
        notificationStatus = PAUSED;
    }

    @Override
    public void stopNotifications() {
        notificationStatus = STOPPED;
    }

    @Override
    public void notifyObservers() {
        final Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        final Controller controller = getController(controllers, Controller.Type.STICK);

        while (true) {
            controller.poll();

            for (Component component : controller.getComponents()) {
                final Component.Identifier identifier = component.getIdentifier();

                if (identifier == Component.Identifier.Axis.X) {
                    float value = component.getPollData();

                    if (abs(value) > applicationConfig.getTriggerOperatingThreshold()) {
                        final EventDetails eventDetails = new EventDetails(identifierMapper.getIdentifier(identifier), STICK_MOVED_HORIZONTALLY);
                        final Observer observer = observersMap.get(eventDetails);
                        if (observer != null) {
                            observer.updateState(new StickMovedHorizontallyEvent(eventDetails.getSource(), value));
                        }
                    }
                } else if (identifier == Component.Identifier.Axis.Y || identifier == Component.Identifier.Axis.RZ) {
                    float value = component.getPollData();

                    if (abs(value) > applicationConfig.getTriggerOperatingThreshold()) {
                        final EventDetails eventDetails = new EventDetails(identifierMapper.getIdentifier(identifier), STICK_MOVED_VERTICALLY);
                        final Observer observer = observersMap.get(eventDetails);
                        if (observer != null) {
                            observer.updateState(new StickMovedVerticallyEvent(eventDetails.getSource(), value));
                        }
                    }
                } else if (identifier instanceof Component.Identifier.Button){
                    float value = component.getPollData();
                    boolean pressed = value == 1.0F;

                    final EventType type = pressed ? BUTTON_PRESSED : BUTTON_RELEASED;
                    final EventDetails eventDetails = new EventDetails(identifierMapper.getIdentifier(identifier), type);
                    final Observer observer = observersMap.get(eventDetails);

                    if (observer != null) {
                        if (pressed) {
                            observer.updateState(new ButtonPressedEvent(eventDetails.getSource(), value));
                        } else {
                            observer.updateState(new ButtonReleasedEvent(eventDetails.getSource(), value));
                        }
                    }
                }
            }

            try {
                Thread.sleep(applicationConfig.getInterrogationDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Controller getController(Controller[] controllers, Controller.Type type) {
        for (Controller controller : controllers) {
            if (controller.getType() == type) {
                return controller;
            }
        }

        throw new RuntimeException("Can't find STICK controller.");
    }
}
