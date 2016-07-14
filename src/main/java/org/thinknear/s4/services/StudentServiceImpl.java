package org.thinknear.s4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thinknear.s4.domain.Status;
import org.thinknear.s4.domain.Student;
import org.thinknear.s4.repositories.StudentRepository;

/**
 * Created by raul on 7/14/16.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository repository;

    @Override
    public void enable(Student student) {
        if(student == null)
            throw new IllegalArgumentException("Student should not be null");

        student.setStatus(Status.ENABLED);
        repository.save(student);
    }

    @Override
    public void disable(Student student) {
        if(student == null)
            throw new IllegalArgumentException("Student should not be null");

        student.setStatus(Status.DISABLED);
        repository.save(student);
    }
}
