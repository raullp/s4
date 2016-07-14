package org.thinknear.s4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.stereotype.Service;
import org.thinknear.s4.domain.Class;
import org.thinknear.s4.domain.SoftDeletableEntity;
import org.thinknear.s4.domain.Status;
import org.thinknear.s4.repositories.ClassRepository;

/**
 * Created by raul on 7/14/16.
 */
public abstract class SoftDeletableServiceImpl<T extends SoftDeletableEntity> implements SoftDeletableService<T> {

    @Override
    public void enable(T entity) {
        updateStatus(entity, Status.ENABLED);
    }

    @Override
    public void disable(T entity) {
        updateStatus(entity, Status.DISABLED);
    }

    private void updateStatus(T entity, Status status) {
        if (entity == null)
            throw new IllegalArgumentException("entity should not be null");

        entity.setStatus(status);
        getRepository().save(entity);
    }

    protected abstract CrudRepository<T, Long> getRepository();
}
