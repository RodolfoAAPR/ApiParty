package com.alves.rodolfo.ApiParty.controller;

import com.alves.rodolfo.ApiParty.model.Person;
import com.alves.rodolfo.ApiParty.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    public void registerPerson(@RequestBody Person person){
        personService.createPerson(person);
    }

    @PostMapping("/{id}/add/{idPerson}")
    public void addPersonToParty(@PathVariable Long id, @PathVariable Long idPerson) {
        personService.addPersonToParty(id, idPerson);
    }
}
