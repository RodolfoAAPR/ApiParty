package com.example.rodolfoalves.ApiParty.ApiParty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Party {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
