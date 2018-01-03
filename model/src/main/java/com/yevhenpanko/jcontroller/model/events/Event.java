package com.yevhenpanko.jcontroller.model.events;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

public interface Event {

    ComponentIdentifier getSource();

    EventType getType();

    float pollData();
}
