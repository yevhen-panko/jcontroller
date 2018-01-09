package com.yevhenpanko.jcontroller.services.cursor;

import com.sun.jna.Native;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

import static com.sun.jna.platform.win32.WinDef.*;

public class CursorInfo extends Structure {
    public int cbSize;
    public int flags;
    public HCURSOR hCursor;
    public POINT ptScreenPos;

    public CursorInfo() {
        this.cbSize = Native.getNativeSize(CursorInfo.class, null);
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("cbSize", "flags", "hCursor", "ptScreenPos");
    }
}