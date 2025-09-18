package com.alves.rodolfo.ApiParty.repository;

import com.alves.rodolfo.ApiParty.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
