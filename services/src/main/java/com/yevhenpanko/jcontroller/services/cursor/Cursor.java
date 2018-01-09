package com.yevhenpanko.jcontroller.services.cursor;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.sun.jna.platform.win32.WinNT.HANDLE;
import static com.sun.jna.platform.win32.WinUser.IMAGE_CURSOR;
import static com.sun.jna.platform.win32.WinUser.LR_SHARED;

/**
 * https://msdn.microsoft.com/pt-br/library/windows/desktop/ms648029(v=vs.85).aspx
 * Test cursors - https://developer.mozilla.org/en-US/docs/Web/CSS/cursor
 * Chromium cursor map -  https://github.com/mageddo/chromium/blob/master/webkit/glue/webcursor_win.cc
 * Load icon example - https://github.com/java-native-access/jna/blob/master/contrib/platform/test/com/sun/jna/platform/win32/GDI32Test.java#L54
 * understanding makeintresource - https://stackoverflow.com/questions/3610565/why-does-makeintresource-work
 * all possible windows error codes - https://msdn.microsoft.com/en-us/library/windows/desktop/ms681386(v=vs.85).aspx
 * Cursor ids - https://msdn.microsoft.com/en-us/library/windows/desktop/ms648391(v=vs.85).aspx
 */
public class Cursor {
    private final Map<HANDLE, CursorShape> cursors;
    private final User32 user32;

    public Cursor() {
        user32 = User32.INSTANCE;
        cursors = loadCursors();
    }

    /**
     * Load all possible cursors to a map
     */
    private Map<HANDLE, CursorShape> loadCursors() {
        final Map<HANDLE, CursorShape> cursors = new HashMap<>();

        for (final CursorShape cursorShape : CursorShape.values()) {
            final Memory memory = new Memory(Native.getNativeSize(Long.class, null));
            memory.setLong(0, cursorShape.getCode());

            final Pointer resource = memory.getPointer(0);
            final HANDLE hcursor = this.user32.LoadImageA(null, resource, IMAGE_CURSOR, 0, 0, LR_SHARED);

            if (hcursor == null || Native.getLastError() != 0) {
                throw new Error("Cursor could not be loaded: " + String.valueOf(Native.getLastError()));
            }

            cursors.put(hcursor, cursorShape);
        }

        return Collections.unmodifiableMap(cursors);
    }

    public CursorShape getCurrentCursor() {
        final CursorInfo cursorInfo = new CursorInfo();
        final int success = this.user32.GetCursorInfo(cursorInfo);

        if (success != 1) {
            throw new Error("Could not retrieve cursor info: " + String.valueOf(Native.getLastError()));
        }

        // sometimes cursor can be hidden, in this case it will be null
        if (cursorInfo.hCursor != null && cursors.containsKey(cursorInfo.hCursor)) {
            return cursors.get(cursorInfo.hCursor);
        }
        
        return null;
    }
}