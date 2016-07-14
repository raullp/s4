package org.thinknear.s4.services;

import org.thinknear.s4.domain.SoftDeletableEntity;
import org.thinknear.s4.domain.Student;

/**
 * Created by raul on 7/14/16.
 */
public interface SoftDeletableService<T extends SoftDeletableEntity> {

    public void enable(T entity);

    public void disable(T entity);
}
