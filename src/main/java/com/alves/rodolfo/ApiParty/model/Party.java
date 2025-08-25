package com.alves.rodolfo.ApiParty.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "address", length = 100, nullable = false)
    @NotBlank
    private String address;

    @Column(name = "total_people", nullable = false)
    @NotBlank
    private int totalPeople;

}
