package org.thinknear.s4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.thinknear.s4.domain.Status;
import org.thinknear.s4.domain.Student;
import org.thinknear.s4.repositories.StudentRepository;

/**
 * Created by raul on 7/14/16.
 */
@Service
public class StudentSoftDeletableService extends SoftDeletableServiceImpl<Student>{

    @Autowired
    StudentRepository repository;

    @Override
    protected CrudRepository<Student, Long> getRepository() {
        return repository;
    }
}
