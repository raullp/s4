package org.thinknear.s4.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.MediaType;
import org.thinknear.s4.config.JSR310DateTimeSerializer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public class TestUtil {


    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    public static byte[] convertObjectToJsonBytes(Object object)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JSR310DateTimeSerializer dateTimeSerializer = new JSR310DateTimeSerializer();

        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(OffsetDateTime.class, dateTimeSerializer);
        module.addSerializer(ZonedDateTime.class, dateTimeSerializer);
        module.addSerializer(LocalDateTime.class, dateTimeSerializer);
        module.addSerializer(Instant.class, dateTimeSerializer);

        mapper.registerModule(module);

        return mapper.writeValueAsBytes(object);
    }

    public static byte[] createByteArray(int size, String data) {
        byte[] byteArray = new byte[size];
        for (int i = 0; i < size; i++) {
            byteArray[i] = Byte.parseByte(data, 2);
        }
        return byteArray;
    }
}
