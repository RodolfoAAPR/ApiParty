package com.alves.rodolfo.ApiParty.repository;

import com.alves.rodolfo.ApiParty.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
