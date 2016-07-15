package org.thinknear.s4.domain.projections;

import org.springframework.data.rest.core.config.Projection;
import org.thinknear.s4.domain.Student;

/**
 * Created by raul on 7/15/16.
 */
@Projection(name = "view", types = Student.class)
public interface ViewStudentProjection {
    Long getId();
    String getFirstName();
    String getLastName();
}
