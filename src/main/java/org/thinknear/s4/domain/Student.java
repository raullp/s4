package org.thinknear.s4.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by raul on 7/13/16.
 */
@Entity
@Data
@ToString(exclude = "classes")
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

    @ManyToMany(mappedBy = "students")
    private List<Class> classes;
}
