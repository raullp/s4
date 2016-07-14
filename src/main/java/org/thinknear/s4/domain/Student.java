package org.thinknear.s4.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by raul on 7/13/16.
 */
@Entity
@Data
public class Student extends AuditingEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Length(min = 1, max = 64)
    private String firstName;

    @NotBlank
    @Length(min = 1, max = 64)
    private String lastName;

    @OneToMany
    private List<Class> classes;
}
