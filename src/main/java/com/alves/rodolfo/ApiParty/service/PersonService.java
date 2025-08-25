package com.alves.rodolfo.ApiParty.service;

import com.alves.rodolfo.ApiParty.model.Person;
import com.alves.rodolfo.ApiParty.repository.PartyRepository;
import com.alves.rodolfo.ApiParty.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PartyRepository partyRepository;

    public void createPerson(Person person){
        personRepository.save(person);
    }

    }


