package com.yevhenpanko.jcontroller.ui;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import com.yevhenpanko.jcontroller.services.eventsprovider.EventsProvider;
import com.yevhenpanko.jcontroller.services.eventsprovider.JInputEventsProvider;
import com.yevhenpanko.jcontroller.services.observer.impl.*;
import com.yevhenpanko.jcontroller.ui.keyboard.VirtualKeyboard;

import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                final ApplicationConfig applicationConfig = ApplicationConfig.getDefault();
                final VirtualKeyboard virtualKeyboard = new VirtualKeyboard();

                Executors.newSingleThreadExecutor().execute(() -> {
                    try {
                        final EventsProvider eventsProvider = new JInputEventsProvider();

                        eventsProvider.register(new LeftStickMovedHorizontallyObserver(applicationConfig));
                        eventsProvider.register(new LeftStickMovedVerticallyObserver(applicationConfig));
                        eventsProvider.register(new RightStickMovedVerticallyObserver(applicationConfig));
                        eventsProvider.register(new RightDownButtonClickedObserver(virtualKeyboard));
                        eventsProvider.register(new OptionsButtonClickedObserver());
                        eventsProvider.register(new HomeButtonDoubleClickedObserver(applicationConfig, eventsProvider));

                        eventsProvider.notifyObservers();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
