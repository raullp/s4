package org.thinknear.s4.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.thinknear.s4.domain.Student;

/**
 * Created by raul on 7/13/16.
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
}
