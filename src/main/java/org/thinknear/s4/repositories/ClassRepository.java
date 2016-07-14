package org.thinknear.s4.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.thinknear.s4.domain.Class;

/**
 * Created by raul on 7/13/16.
 */
@RepositoryRestResource
public interface ClassRepository extends PagingAndSortingRepository<org.thinknear.s4.domain.Class, Long> {

    @Override
    @RestResource(exported = false)
    void delete(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Class aClass);
}
