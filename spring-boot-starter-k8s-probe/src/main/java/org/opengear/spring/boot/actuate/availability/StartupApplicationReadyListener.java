package org.opengear.spring.boot.actuate.availability;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class StartupApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        AvailabilityChangeEvent.publish(event.getApplicationContext(), StartupState.CORRECT);
    }
}
