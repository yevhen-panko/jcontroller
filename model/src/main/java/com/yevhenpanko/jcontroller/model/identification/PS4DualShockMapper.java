package com.yevhenpanko.jcontroller.model.identification;

import net.java.games.input.Component;

import java.util.HashMap;
import java.util.Map;

public class PS4DualShockMapper implements IdentifierMapper {
    private final Map<Component.Identifier, ComponentIdentifier> identifiersMap;

    public PS4DualShockMapper() {
        this.identifiersMap = new HashMap<>();

        identifiersMap.put(Component.Identifier.Axis.X, ComponentIdentifier.LEFT_STICK);
        identifiersMap.put(Component.Identifier.Axis.RX, ComponentIdentifier.LEFT_SHIFT);
        identifiersMap.put(Component.Identifier.Axis.Y, ComponentIdentifier.LEFT_STICK);
        identifiersMap.put(Component.Identifier.Axis.RY, ComponentIdentifier.RIGHT_SHIFT);
        identifiersMap.put(Component.Identifier.Axis.Z, ComponentIdentifier.RIGHT_STICK);
        identifiersMap.put(Component.Identifier.Axis.RZ, ComponentIdentifier.RIGHT_STICK);
        identifiersMap.put(Component.Identifier.Button._0, ComponentIdentifier.RIGHT_LEFT_BUTTON);
        identifiersMap.put(Component.Identifier.Button._1, ComponentIdentifier.RIGHT_DOWN_BUTTON);
        identifiersMap.put(Component.Identifier.Button._2, ComponentIdentifier.RIGHT_RIGHT_BUTTON);
        identifiersMap.put(Component.Identifier.Button._3, ComponentIdentifier.RIGHT_UP_BUTTON);
        identifiersMap.put(Component.Identifier.Button._4, ComponentIdentifier.LEFT_BUMPER_BUTTON);
        identifiersMap.put(Component.Identifier.Button._5, ComponentIdentifier.RIGHT_BUMPER_BUTTON);
        identifiersMap.put(Component.Identifier.Button._6, ComponentIdentifier.LEFT_SHIFT);
        identifiersMap.put(Component.Identifier.Button._7, ComponentIdentifier.RIGHT_SHIFT);
        identifiersMap.put(Component.Identifier.Button._8, ComponentIdentifier.SHARE_BUTTON);
        identifiersMap.put(Component.Identifier.Button._9, ComponentIdentifier.OPTIONS_BUTTON);
        identifiersMap.put(Component.Identifier.Button._10, ComponentIdentifier.LEFT_STICK);
        identifiersMap.put(Component.Identifier.Button._11, ComponentIdentifier.RIGHT_STICK);
        identifiersMap.put(Component.Identifier.Button._12, ComponentIdentifier.HOME_BUTTON);
        identifiersMap.put(Component.Identifier.Button._13, ComponentIdentifier.D_PAD);
    }

    @Override
    public ComponentIdentifier getIdentifier(Component.Identifier identifier) {
        return identifiersMap.get(identifier);
    }
}
