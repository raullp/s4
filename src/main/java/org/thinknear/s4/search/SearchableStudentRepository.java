package org.thinknear.s4.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.ElasticsearchRepositoryConfigExtension;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by raul on 7/14/16.
 */
@RestResource(exported = false)
public interface SearchableStudentRepository extends ElasticsearchRepository<SearchableStudent, Long> {

}
