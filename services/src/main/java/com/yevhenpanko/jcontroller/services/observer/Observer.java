package com.yevhenpanko.jcontroller.services.observer;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;

public interface Observer {

    void updateState(Event... events);

    EventDetails listenFor();
}
