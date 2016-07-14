package org.thinknear.s4.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by raul on 7/13/16.
 */
@Data
@ToString(exclude = "students")
@Entity
public class Class extends AuditingEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @NotBlank
    @Length(max = 64)
    @Column(length = 64, unique = true)
    private String code;

    @NotEmpty
    @NotBlank
    @Length(max = 255)
    private String title;

    @Lob
    private String description;

    @ManyToMany
    private List<Student> students;
}
