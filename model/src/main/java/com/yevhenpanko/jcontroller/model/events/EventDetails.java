package com.yevhenpanko.jcontroller.model.events;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventDetails {
    private boolean pressed;
    private float rotationAngle;
    private float movingDistance;
}
