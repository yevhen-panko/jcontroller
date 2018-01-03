package com.yevhenpanko.jcontroller.model.events;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventDetails {
    private final ComponentIdentifier source;
    private final EventType type;
}
