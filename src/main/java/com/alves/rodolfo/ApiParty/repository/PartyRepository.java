package com.alves.rodolfo.ApiParty.repository;

import com.alves.rodolfo.ApiParty.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {
}
