package com.iyex.hotelmgt.domain.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryName;

    @OneToMany(mappedBy = "country")
    @ToString.Exclude
    private Set<Region> regions;

}
