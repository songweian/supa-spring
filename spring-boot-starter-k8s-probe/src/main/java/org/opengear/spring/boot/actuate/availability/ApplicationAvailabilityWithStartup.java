package org.opengear.spring.boot.actuate.availability;

import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.AvailabilityState;

public interface ApplicationAvailabilityWithStartup extends ApplicationAvailability {

    default AvailabilityState getStartupState() {
        return getState(StartupState.class, StartupState.UNKNOWN);
    }
}
