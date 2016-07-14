package org.thinknear.s4.domain.listeners;

import org.springframework.stereotype.Component;
import org.thinknear.s4.domain.SoftDeletableEntity;
import org.thinknear.s4.domain.Status;

import javax.persistence.PrePersist;

/**
 * Created by raul on 7/14/16.
 */
@Component
public class SoftDeletableEntityListener {

    @PrePersist
    public void handle(SoftDeletableEntity softDeletableEntity) {
        softDeletableEntity.setStatus(Status.ACTIVE);
    }
}
