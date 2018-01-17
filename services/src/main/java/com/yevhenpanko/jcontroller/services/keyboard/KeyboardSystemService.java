package com.yevhenpanko.jcontroller.services.keyboard;

import com.sun.jna.platform.win32.WinDef;
import com.yevhenpanko.jcontroller.services.cursor.User32;

import java.util.Optional;

public class KeyboardSystemService {
    private User32 user32;

    public KeyboardSystemService() {
        user32 = User32.INSTANCE;
    }

    public Optional<KeyboardLayout> getKeyboardLayout() {
        final WinDef.HWND foregroundWindow = user32.GetForegroundWindow();
        int processId = user32.GetWindowThreadProcessId(foregroundWindow, null);
        int code = user32.GetKeyboardLayout(new WinDef.DWORD(processId));

        return KeyboardLayout.getKeyboardLayout(code);
    }
}
