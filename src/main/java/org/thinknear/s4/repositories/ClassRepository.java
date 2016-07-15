package org.thinknear.s4.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
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

    @Query("FROM Class c WHERE c.code like %:code%")
    Page<Class> findByCode(@Param("code") String code, Pageable pageable);

    @Query("FROM Class c WHERE c.title like %:title%")
    Page<Class> findByTitle(@Param("title")String title, Pageable pageable);

    @Query("FROM Class c WHERE c.description like %:description%")
    Page<Class> findByDescription(@Param("description")String description, Pageable pageable);

    @Query("FROM Class c WHERE c.code like %:query% OR c.title like %:query% or c.description like %:query%")
    Page<Class> search(@Param("query")String query, Pageable pageable);
}
