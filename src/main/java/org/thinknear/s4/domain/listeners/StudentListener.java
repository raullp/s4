package org.thinknear.s4.domain.listeners;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.thinknear.s4.domain.Student;
import org.thinknear.s4.search.SearchableStudent;
import org.thinknear.s4.search.SearchableStudentRepository;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

/**
 * Created by raul on 7/14/16.
 */
@RepositoryEventHandler
public class StudentListener {

//    @Autowired
    protected SearchableStudentRepository repository;

    public StudentListener(SearchableStudentRepository searchableStudentRepository) {
        this.repository = searchableStudentRepository;
    }

    @HandleAfterSave
    public void handlePostPersist(Student student)
    {
        SearchableStudent searchableStudent = new SearchableStudent();
        BeanUtils.copyProperties(student, searchableStudent);
        repository.save(searchableStudent);
    }

    @HandleAfterCreate
    public void handlePostUpdate(Student student)
    {
        SearchableStudent searchableStudent = new SearchableStudent();
        BeanUtils.copyProperties(student, searchableStudent);
        repository.save(searchableStudent);
    }

    @HandleAfterDelete
    public void handlePostDelete(Student student)
    {
        repository.delete(student.getId());
    }

}
