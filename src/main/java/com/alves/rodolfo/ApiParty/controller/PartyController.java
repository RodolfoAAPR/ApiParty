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
}
