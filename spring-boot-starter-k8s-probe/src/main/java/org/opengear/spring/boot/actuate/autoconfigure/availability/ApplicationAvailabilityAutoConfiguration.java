package org.opengear.spring.boot.actuate.autoconfigure.availability;

import org.opengear.spring.boot.actuate.availability.ApplicationAvailabilityBeanWithStartup;
import org.opengear.spring.boot.actuate.availability.ApplicationAvailabilityWithStartup;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ApplicationAvailabilityAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(ApplicationAvailability.class)
    public ApplicationAvailabilityWithStartup applicationAvailability() {
        return new ApplicationAvailabilityBeanWithStartup();
    }
}
