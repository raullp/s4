package org.thinknear.s4.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.Client;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.thinknear.s4.domain.listeners.StudentListener;
import org.thinknear.s4.search.SearchableStudentRepository;

import java.io.IOException;

/**
 * Created by raul on 7/14/16.
 */
@EnableElasticsearchRepositories(basePackages = "org.thinknear.s4.search")
@AutoConfigureAfter(value = { JacksonConfiguration.class })
@Configuration
public class ElasticsearchConfig {
    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client, Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
        return new ElasticsearchTemplate(client, new CustomEntityMapper(jackson2ObjectMapperBuilder.createXmlMapper(false).build()));
    }

    public class CustomEntityMapper implements EntityMapper {

        private ObjectMapper objectMapper;

        public CustomEntityMapper(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        }

        @Override
        public String mapToString(Object object) throws IOException {
            return objectMapper.writeValueAsString(object);
        }

        @Override
        public <T> T mapToObject(String source, Class<T> clazz) throws IOException {
            return objectMapper.readValue(source, clazz);
        }
    }

    @Bean
    StudentListener studentListener(SearchableStudentRepository searchableStudentRepository){
        return new StudentListener(searchableStudentRepository);
    }
}
