package com.yevhenpanko.jcontroller.services.eventsprovider;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventType;

public interface Observer {

    void updateState(Event... events);

    EventType[] listenFor();
}
