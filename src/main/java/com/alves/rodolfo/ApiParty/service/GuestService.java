package com.alves.rodolfo.ApiParty.service;

import com.alves.rodolfo.ApiParty.model.Guest;
import com.alves.rodolfo.ApiParty.repository.PartyRepository;
import com.alves.rodolfo.ApiParty.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private PartyRepository partyRepository;

    public Guest findById(Long id){
        Optional<Guest> guest = this.guestRepository.findById(id);
        return guest.orElseThrow(() -> new RuntimeException(
                "Usuário " + Guest.class.getName() + " não encontrado."
        ));
    }

    public Guest createGuest(Guest guest){
        if(guest.getAge() < 18)
            ResponseEntity.badRequest().body(guest.getName() + " must have 18 years old at least!");

        return guestRepository.save(guest);
    }

    public List<Guest> findAllGuests(){
        return guestRepository.findAll();
    }
}


