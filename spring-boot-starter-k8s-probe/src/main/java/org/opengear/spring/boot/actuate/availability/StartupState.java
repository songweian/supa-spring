package org.opengear.spring.boot.actuate.availability;

import org.springframework.boot.availability.AvailabilityState;

public enum StartupState implements AvailabilityState {

    /**
     * The application is started and its internal state is correct.
     */
    CORRECT,

    /**
     * The application is starting but its internal state is not ready.
     */
    UNKNOWN
}
