package com.iyex.hotelmgt.domain.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regionName;

    @ManyToOne
    @JoinColumn
    private Country country;

    @OneToMany(mappedBy = "region")
    private Set<City> cities;
}
