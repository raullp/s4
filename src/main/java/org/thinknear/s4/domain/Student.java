package org.thinknear.s4.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.thinknear.s4.domain.listeners.SoftDeletableEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * Created by raul on 7/13/16.
 */
@Data
@ToString(exclude = "classes")
@EntityListeners(SoftDeletableEntityListener.class)
@Entity
public class Student extends AuditingEntity implements SoftDeletableEntity{

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

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;


    public Student() {}

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }
}
