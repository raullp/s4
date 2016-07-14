package org.thinknear.s4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.thinknear.s4.domain.Class;
import org.thinknear.s4.repositories.ClassRepository;

/**
 * Created by raul on 7/14/16.
 */
@Service
public class ClassSoftDeletableService extends SoftDeletableServiceImpl {

    @Autowired
    ClassRepository classRepository;


    @Override
    protected CrudRepository getRepository() {
        return classRepository;
    }
}
