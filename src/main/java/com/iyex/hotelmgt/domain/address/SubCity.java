package com.iyex.hotelmgt.domain.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class SubCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subCityName;

    @OneToMany(mappedBy = "subCity")
    @ToString.Exclude
    @JsonManagedReference
    private Set<District> districts;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private City city;
}
