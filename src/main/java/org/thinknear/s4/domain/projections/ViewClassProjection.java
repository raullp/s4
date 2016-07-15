package org.thinknear.s4.domain.projections;

import org.springframework.data.rest.core.config.Projection;
import org.thinknear.s4.domain.Class;
import org.thinknear.s4.domain.Student;

import java.util.List;

/**
 * Created by raul on 7/15/16.
 */
@Projection(name = "view", types = Class.class)
public interface ViewClassProjection {

    Long getId();
    String getCode();
    String getTitle();
    String getDescription();
}
