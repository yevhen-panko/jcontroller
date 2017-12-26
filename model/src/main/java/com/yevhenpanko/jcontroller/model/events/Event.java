package com.yevhenpanko.jcontroller.model.events;

public interface Event {

    String getName();

    EventType getEventType();

    EventDetails getEventDetails();
}
