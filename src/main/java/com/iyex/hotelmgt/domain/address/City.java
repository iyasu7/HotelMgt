package com.iyex.hotelmgt.domain.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@Setter
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;

    @OneToMany(mappedBy = "city")
    @ToString.Exclude
    @JsonManagedReference
    private List<SubCity> subCities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    @JsonBackReference
    private Region region;

}
