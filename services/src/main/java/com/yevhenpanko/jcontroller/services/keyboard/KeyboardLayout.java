
package com.yevhenpanko.jcontroller.services.keyboard;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum KeyboardLayout {
    ENG(67699721),
    RUS(68748313),
    NONE(-1);

    private int code;

    KeyboardLayout(int code) {
        this.code = code;
    }

    public static Optional<KeyboardLayout> getKeyboardLayout(int code) {
        for (KeyboardLayout keyboardLayout : values()) {
            if (keyboardLayout.code == code) {
                return Optional.of(keyboardLayout);
            }
        }

        return Optional.empty();
    }
}