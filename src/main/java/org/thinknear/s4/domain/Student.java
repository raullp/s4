package org.thinknear.s4.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by raul on 7/13/16.
 */
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private long version;

    @NotBlank
    @Length(min = 1, max = 64)
    private String firstName;

    @NotBlank
    @Length(min = 1, max = 64)
    private String lastName;
}
