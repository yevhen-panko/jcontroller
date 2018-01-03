package com.yevhenpanko.jcontroller.model;


import lombok.Getter;
import net.java.games.input.Controller;

/**
 * Represents configuration details.
 *
 * @author yevhen.panko
 */

@Getter
public class ApplicationConfig {
    private long interrogationDelay;
    private int mouseMovingStepSize;
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
    private ApplicationConfig(long interrogationDelay, int mouseMovingStepSize, float triggerOperatingThreshold) {
        this.interrogationDelay = interrogationDelay;
        this.mouseMovingStepSize = mouseMovingStepSize;
        this.triggerOperatingThreshold = triggerOperatingThreshold;
    }

    private ApplicationConfig() {
    }

    public static ApplicationConfig getDefault() {
        return new ApplicationConfig(10L, 10, 0.2F);
    }
}
