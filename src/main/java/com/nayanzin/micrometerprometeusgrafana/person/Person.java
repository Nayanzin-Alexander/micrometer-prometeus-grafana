package com.nayanzin.micrometerprometeusgrafana.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static java.lang.Long.MIN_VALUE;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
class Person implements Serializable {
    private static final long serialVersionUID = MIN_VALUE;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;
}
