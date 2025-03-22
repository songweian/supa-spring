package org.opengear.spring.boot.actuate.availability;

import org.springframework.boot.actuate.availability.AvailabilityStateHealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.availability.AvailabilityState;

public class StartupStateHealthIndicator extends AvailabilityStateHealthIndicator {
    public StartupStateHealthIndicator(ApplicationAvailabilityWithStartup availability) {
        super(availability, StartupState.class, (statusMappings) -> {
            statusMappings.add(StartupState.CORRECT, Status.UP);
            statusMappings.add(StartupState.UNKNOWN, Status.UNKNOWN);
        });
    }

    protected AvailabilityState getState(ApplicationAvailabilityBeanWithStartup applicationAvailability) {
        return applicationAvailability.getStartupState();
    }
}
