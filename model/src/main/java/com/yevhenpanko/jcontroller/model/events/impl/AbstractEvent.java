package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;
import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventType;

public abstract class AbstractEvent implements Event {
    private final ComponentIdentifier source;
    private final EventType type;
    private final float value;

    public AbstractEvent(ComponentIdentifier source, EventType type, float value) {
        this.source = source;
        this.type = type;
        this.value = value;
    }

    @Override
    public ComponentIdentifier getSource() {
        return source;
    }

    @Override
    public EventType getType() {
        return type;
    }

    @Override
    public float pollData() {
        return value;
    }
}
