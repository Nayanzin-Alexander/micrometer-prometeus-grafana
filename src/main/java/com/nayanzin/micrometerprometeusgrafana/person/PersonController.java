package com.nayanzin.micrometerprometeusgrafana.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public Long save(@NotNull @Valid PersonDto person) {
        return personService.create(person.toPerson()).getId();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable("id") long id) {
        return personService.getById(id)
                .map(PersonDto::from)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }

    @GetMapping
    public Page<PersonDto> getPage(Pageable pageable) {
        return personService.getPage(pageable)
                .map(PersonDto::from);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonDto> removeById(@PathVariable("id") long id) {
        return personService.removeById(id)
                .map(PersonDto::from)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }
}
