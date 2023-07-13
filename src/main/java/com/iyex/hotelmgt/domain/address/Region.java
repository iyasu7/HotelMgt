package com.iyex.hotelmgt.domain.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Country country;

    @OneToMany(mappedBy = "region")
    @JsonManagedReference
    private Set<City> cities;
}
