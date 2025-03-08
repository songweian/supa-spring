package org.opengear.supa.http;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.opengear.supa.jackson.LongToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UniJacksonCustomizer {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonBuilder() {
        return builder -> builder
                .modules(new JavaTimeModule())
                .serializerByType(Long.class, new LongToStringSerializer())
                .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .featuresToEnable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
                .featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
                .featuresToEnable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

}
