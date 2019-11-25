package com.nayanzin.micrometerprometeusgrafana.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
