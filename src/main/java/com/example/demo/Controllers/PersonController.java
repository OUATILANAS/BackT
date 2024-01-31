package com.example.demo.Controllers;

import com.example.demo.Models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Services.PersonService;
import java.util.List;

@RestController
@RequestMapping("/api/monobjet")
public class PersonController {

    @Autowired
    private PersonService PersonService;

    @GetMapping
    public List<Person> getAllMonPersons() {
        List<Person> persons = PersonService.getAllPersons();
        return persons;

    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person Person) {
        Person aperson = PersonService.addPerson(Person);
        return ResponseEntity.ok(aperson);

    }

    @PostMapping("/random")
    public ResponseEntity<Person> addRandomPersons() {
        Person newRandomPerson = PersonService.addRandomPerson();
        return ResponseEntity.ok(newRandomPerson);
    }
}
