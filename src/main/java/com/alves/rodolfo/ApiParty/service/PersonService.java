package com.alves.rodolfo.ApiParty.service;

import com.alves.rodolfo.ApiParty.model.Person;
import com.alves.rodolfo.ApiParty.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void createPerson(Person person){
        personRepository.save(person);
    }

    public Person findPersonById(Long id){
        return personRepository.findById(id)
                .orElse(null);
    }
}


