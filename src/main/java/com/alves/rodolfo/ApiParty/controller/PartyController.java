package com.alves.rodolfo.ApiParty.controller;

import com.alves.rodolfo.ApiParty.model.Party;
import com.alves.rodolfo.ApiParty.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyRepository partyRepository;

    @PostMapping("/register")
    public ResponseEntity<String> createParty(@RequestBody Party party){
        partyRepository.save(party);

        return ResponseEntity.ok(party.getName() + " party registered successfully!");
    }

    @GetMapping
    public List<Party> getAllParties(){
        return partyRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateParty(@RequestBody Party newParty, @PathVariable Long id){
        return partyRepository.findById(id).map(party -> {
            party.setName(newParty.getName());
            party.setAddress(newParty.getAddress());
            party.setTotalPeople(newParty.getTotalPeople());

            partyRepository.save(party);

            return ResponseEntity.ok(party.getName() + " modified successfully!");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParty(@PathVariable Long id){
        this.partyRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
