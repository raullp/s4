package org.thinknear.s4.services;

import org.thinknear.s4.domain.Student;

/**
 * Created by raul on 7/14/16.
 */
public interface StudentService {

    public void enable(Student student);

    public void disable(Student student);
}
