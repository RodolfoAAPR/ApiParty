package com.alves.rodolfo.ApiParty.controller;

import com.alves.rodolfo.ApiParty.model.Person;
import com.alves.rodolfo.ApiParty.repository.PersonRepository;
import com.alves.rodolfo.ApiParty.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;


    @PostMapping("/register-guest")
    public ResponseEntity<String> registerPerson(@RequestBody Person person) {
        if(person.getAge() < 18){
            return ResponseEntity.badRequest().body(person.getName() + " must have 18 years old or more.");
        }

        personRepository.save(person);
        return ResponseEntity.ok(person.getName()+ " registered successfully.");
    }

    @GetMapping
    public List<Person> showAllPeople(){
        return personRepository.findAll();
    }
}
