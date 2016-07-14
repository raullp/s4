package org.thinknear.s4.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.*;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * Created by raul on 7/13/16.
 */
@Configuration
public class JacksonConfiguration {

    private static final DateTimeFormatter ISOFormatter =
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of("Z"));

    @Bean
    Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        JavaTimeModule module = new JavaTimeModule();
        JSR310DateTimeSerializer INSTANCE = new JSR310DateTimeSerializer();
        module.addSerializer(OffsetDateTime.class, INSTANCE);
        module.addSerializer(ZonedDateTime.class, INSTANCE);
        module.addSerializer(LocalDateTime.class, INSTANCE);
        module.addSerializer(Instant.class, INSTANCE);

        return new Jackson2ObjectMapperBuilder()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .findModulesViaServiceLoader(true)
                .modulesToInstall(module);
    }

    public final class JSR310DateTimeSerializer extends JsonSerializer<TemporalAccessor> {

        @Override
        public void serialize(TemporalAccessor value, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
            generator.writeString(ISOFormatter.format(value));
        }
    }
}

