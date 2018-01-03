package com.yevhenpanko.jcontroller.model;


import lombok.Getter;

/**
 * Represents configuration details.
 *
 * @author yevhen.panko
 */

@Getter
public class ApplicationConfig {
    private long interrogationDelay;
    private long doubleClickDelay;
    private int mouseMovingStepSize;
    private int mouseScrollingStepSize;
    private float triggerOperatingThreshold;

    /**
     * Creates new instance of Application config class with specified parameters.
     * Constructor is private to prevent creating it in wrong way.
     * Use static method <tt>getDefault()</tt> method to create new instance with default parameters.
     *
     * @param interrogationDelay        the delay on pooling events from the controller
     * @param mouseMovingStepSize       the distance in pixels to which the cursor will be moved in one iteration
     * @param triggerOperatingThreshold the threshold to filter false trigger events. Controller may produce false events.
     */
    private ApplicationConfig(
            long interrogationDelay,
            long doubleClickDelay,
            int mouseMovingStepSize,
            int mouseScrollingStepSize,
            float triggerOperatingThreshold
    ) {
        this.interrogationDelay = interrogationDelay;
        this.doubleClickDelay = doubleClickDelay;
        this.mouseMovingStepSize = mouseMovingStepSize;
        this.mouseScrollingStepSize = mouseScrollingStepSize;
        this.triggerOperatingThreshold = triggerOperatingThreshold;
    }

    private ApplicationConfig() {
    }

    public static ApplicationConfig getDefault() {
        return new ApplicationConfig(10L, 300L, 10, 1, 0.2F);
    }
}
