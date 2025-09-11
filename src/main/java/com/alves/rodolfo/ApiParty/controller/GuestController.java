package com.alves.rodolfo.ApiParty.controller;

import com.alves.rodolfo.ApiParty.model.Guest;
import com.alves.rodolfo.ApiParty.repository.PersonRepository;
import com.alves.rodolfo.ApiParty.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;


    @PostMapping("/register")
    public ResponseEntity<String> registerGuest(@RequestBody Guest person) {
        if(person.getAge() < 18){
            return ResponseEntity.badRequest().body(person.getName() + " must have 18 years old or more.");
        }

        personRepository.save(person);
        return ResponseEntity.ok(person.getName()+ " registered successfully.");
    }

    @GetMapping
    public List<Guest> showAllGuests(){
        return personRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGuest(@RequestBody Guest newGuest, @PathVariable Long id){
        return personRepository.findById(id).map(person -> {
            if(newGuest.getAge() < 18) {
                return ResponseEntity.badRequest().body(newGuest.getName() + " must have 18 years old at least.");
            }

            person.setName(newGuest.getName());
            person.setAge(newGuest.getAge());
            person.setCpf(newGuest.getCpf());

            personRepository.save(person);

            return ResponseEntity.ok(person.getName() + " modified successfully");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id){
        personRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
