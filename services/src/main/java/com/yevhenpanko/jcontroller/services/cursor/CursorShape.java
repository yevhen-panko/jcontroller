package com.yevhenpanko.jcontroller.services.cursor;

public enum CursorShape {
    APPSTARTING(32650),
    NORMAL(32512),
    CROSS(32515),
    HAND(32649),
    HELP(32651),
    IBEAM(32513),
    NO(32648),
    SIZEALL(32646),
    SIZENESW(32643),
    SIZENS(32645),
    SIZENWSE(32642),
    SIZEWE(32644),
    UP(32516),
    WAIT(32514),
    PEN(32631);

    private final int code;

    CursorShape(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}