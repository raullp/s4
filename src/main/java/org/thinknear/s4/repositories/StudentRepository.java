package org.thinknear.s4.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.thinknear.s4.domain.Class;
import org.thinknear.s4.domain.Student;

/**
 * Created by raul on 7/13/16.
 */
@RepositoryRestResource
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    @Override
    @RestResource(exported = false)
    void delete(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Student student);

    @Query("FROM Student s WHERE s.firstName like %:firstName%")
    Page<Student> findByFirstName(@Param("firstName")String firstName, Pageable pageable);

    @Query("FROM Student s WHERE s.lastName like %:lastName%")
    Page<Student> findByLastName(@Param("lastName")String lastName, Pageable pageable);

    @Query("FROM Student s WHERE s.firstName like %:query% or s.lastName like %:query%")
    Page<Student> search(@Param("query")String description, Pageable pageable);
}
