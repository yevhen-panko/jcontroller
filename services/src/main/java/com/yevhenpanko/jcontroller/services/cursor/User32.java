package com.yevhenpanko.jcontroller.services.cursor;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;

import static com.sun.jna.platform.win32.WinNT.HANDLE;

public interface User32 extends com.sun.jna.Library {
    User32 INSTANCE = Native.loadLibrary("User32.dll", User32.class);

    /**
     * https://msdn.microsoft.com/en-us/library/ms648389(v=vs.85).aspx
     */
    int GetCursorInfo(CursorInfo cursorInfo);

    /**
     * https://msdn.microsoft.com/en-us/library/windows/desktop/ms648045(v=vs.85).aspx
     */
    HANDLE LoadImageA(
            WinDef.HINSTANCE hinst,
            Pointer lpszName,
            int uType,
            int cxDesired,
            int cyDesired,
            int fuLoad
    );
}