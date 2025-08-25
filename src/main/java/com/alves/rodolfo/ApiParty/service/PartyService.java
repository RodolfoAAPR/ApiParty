package com.alves.rodolfo.ApiParty.service;

import com.alves.rodolfo.ApiParty.model.Party;
import com.alves.rodolfo.ApiParty.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    public void createParty(Party party){
        partyRepository.save(party);
    }

    public Party findPartyById(Long id){
        return partyRepository.findById(id)
                .orElse(null);
    }
}
