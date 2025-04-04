/*
 * Copyright 2012-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opengear.spring.boot.actuate.autoconfigure.availability;

import org.springframework.boot.actuate.availability.AvailabilityStateHealthIndicator;
import org.springframework.boot.actuate.availability.LivenessStateHealthIndicator;
import org.springframework.boot.actuate.availability.ReadinessStateHealthIndicator;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.context.annotation.Bean;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for
 * {@link AvailabilityStateHealthIndicator}.
 *
 * @author Brian Clozel
 * @since 2.3.2
 */
@AutoConfiguration(after = ApplicationAvailabilityAutoConfiguration.class)
public class AvailabilityHealthContributorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "livenessStateHealthIndicator")
    @ConditionalOnProperty(prefix = "opengear.management.health.livenessstate", name = "enabled", havingValue = "true", matchIfMissing = true)
    public LivenessStateHealthIndicator livenessStateHealthIndicator(ApplicationAvailability applicationAvailability) {
        return new LivenessStateHealthIndicator(applicationAvailability);
    }

    @Bean
    @ConditionalOnMissingBean(name = "readinessStateHealthIndicator")
    @ConditionalOnProperty(prefix = "opengear.management.health.readinessstate", name = "enabled", havingValue = "true", matchIfMissing = true)
    public ReadinessStateHealthIndicator readinessStateHealthIndicator(
            ApplicationAvailability applicationAvailability) {
        return new ReadinessStateHealthIndicator(applicationAvailability);
    }

}
