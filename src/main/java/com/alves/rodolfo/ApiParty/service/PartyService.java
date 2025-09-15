package com.alves.rodolfo.ApiParty.service;

import com.alves.rodolfo.ApiParty.model.Party;
import com.alves.rodolfo.ApiParty.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    public Party createParty(Party party){
        return partyRepository.save(party);
    }

    public Party findPartyById(Long id){
        return partyRepository.findById(id)
                .orElse(null);
    }

    public List<Party> findAllParties(){
        return partyRepository.findAll();
    }

    public ResponseEntity<String> updateParty(@RequestBody Party newParty, @PathVariable Long id){
        return partyRepository.findById(id).map(party -> {
           party.setName(newParty.getName());
           party.setAddress(newParty.getAddress());
           party.setTotalPeople(newParty.getTotalPeople());

           partyRepository.save(party);

           return ResponseEntity.ok(party.getName() + " party modified successfully");
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<String> deleteParty(@PathVariable Long id){
        this.partyRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
