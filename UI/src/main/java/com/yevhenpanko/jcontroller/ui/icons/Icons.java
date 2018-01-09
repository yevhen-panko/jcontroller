package com.yevhenpanko.jcontroller.ui.icons;

import lombok.Getter;

import javax.swing.*;

@Getter
public enum Icons {
    BACKSPACE("/icons/backspace.png"),
    ENTER("/icons/return.png"),
    SHIFT("/icons/shift.png"),
    LANGUAGE("/icons/language.png");

    private String path;

    Icons(String path) {
        this.path = path;
    }

    public ImageIcon getImageIcon() {
        return new ImageIcon(Icons.class.getResource(this.path));
    }
}
