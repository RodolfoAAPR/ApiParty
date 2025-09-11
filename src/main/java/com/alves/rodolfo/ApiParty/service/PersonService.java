package com.alves.rodolfo.ApiParty.service;

import com.alves.rodolfo.ApiParty.model.Guest;
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

    public Guest findById(Long id){
        Optional<Guest>  person = this.personRepository.findById(id);
        return person.orElseThrow(() -> new RuntimeException(
                "Usuário " + Guest.class.getName() + " não encontrado."
        ));
    }

    public Guest createPerson(Guest person){
        return personRepository.save(person);
    }

}


