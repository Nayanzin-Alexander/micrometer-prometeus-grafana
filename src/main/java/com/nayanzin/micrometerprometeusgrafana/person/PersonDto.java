package com.nayanzin.micrometerprometeusgrafana.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class PersonDto {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    private String email;

    static PersonDto from(Person p) {
        return PersonDto.builder()
                .id(p.getId())
                .firstName(p.getFirstName())
                .lastName(p.getLastName())
                .email(p.getEmail()).build();
    }

    Person toPerson() {
        return Person.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
    }
}
