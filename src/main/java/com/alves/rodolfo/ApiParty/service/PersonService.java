package com.alves.rodolfo.ApiParty.service;

import com.alves.rodolfo.ApiParty.model.Person;
import com.alves.rodolfo.ApiParty.repository.PartyRepository;
import com.alves.rodolfo.ApiParty.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PartyRepository partyRepository;

    public Person findById(Long id){
        Optional<Person>  person = this.personRepository.findById(id);
        return person.orElseThrow(() -> new RuntimeException(
                "Usuário " + Person.class.getName() + " não encontrado."
        ));
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

}


