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

/**
 * Created by raul on 7/13/16.
 */
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private ZonedDateTime createdDate;

    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    private ZonedDateTime modifiedDate;
}
