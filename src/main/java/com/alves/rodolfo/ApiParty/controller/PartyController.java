package com.alves.rodolfo.ApiParty.controller;

import com.alves.rodolfo.ApiParty.model.Party;
import com.alves.rodolfo.ApiParty.repository.PartyRepository;
import com.alves.rodolfo.ApiParty.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private PartyService partyService;

    @PostMapping("/register")
    public Party createParty(@RequestBody Party party){
        return partyService.createParty(party);
    }

    @GetMapping
    public List<Party> getAllParties(){
        return partyRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateParty(@RequestBody Party newParty, @PathVariable Long id){
        return partyService.updateParty(newParty, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParty(@PathVariable Long id){
        return this.partyService.deleteParty(id);
    }
}