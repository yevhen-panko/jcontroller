package com.yevhenpanko.jcontroller.ui.keyboard;


import com.yevhenpanko.jcontroller.ui.icons.Icons;
import lombok.Getter;

/**
 * Represents physical keyboard key.
 *
 * @author yevhen_panko
 */
@Getter
public class VirtualKey {
    private String label;
    private Icons icon;
    private String layoutParams;
    private Runnable action;

    /**
     * Creates new instance of virtual key
     *
     * @param label        - text that would be visible on button
     * @param layoutParams - http://www.miglayout.com/QuickStart.pdf
     * @param action       - the action that would be performed on button click
     */
    public VirtualKey(String label, String layoutParams, Runnable action) {
        this.label = label;
        this.layoutParams = layoutParams;
        this.action = action;
    }

    /**
     * Creates new instance of virtual key
     *
     * @param icon         - icon that would be visible on button
     * @param layoutParams - http://www.miglayout.com/QuickStart.pdf
     * @param action       - the action that would be performed on button click
     */
    public VirtualKey(Icons icon, String layoutParams, Runnable action) {
        this.icon = icon;
        this.layoutParams = layoutParams;
        this.action = action;
    }
}
