package com.nayanzin.micrometerprometeusgrafana.person;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Optional.empty;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Timed
    public Optional<Person> getById(long id) {
        return personRepository.findById(id);
    }

    @Timed
    public Page<Person> getPage(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Timed
    public Optional<Person> removeById(long id) {
        return getById(id)
                .map(person -> {
                    personRepository.delete(person);
                    return Optional.of(person);
                })
                .orElse(empty());
    }

    @Timed
    public Person create(Person person) {
        return personRepository.save(person);
    }
}
