package com.iyex.hotelmgt.domain.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SubCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subCityName;
    @OneToMany(mappedBy = "subCity")
    @ToString.Exclude
    private Set<District> districts;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
