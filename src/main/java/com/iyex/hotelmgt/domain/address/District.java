package com.iyex.hotelmgt.domain.address;

import com.iyex.hotelmgt.domain.Hotel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String districtName;

    @OneToMany(mappedBy = "district")
    @ToString.Exclude
    private List<Address> address;

    @OneToMany(mappedBy = "district")
    @ToString.Exclude
    private Set<Hotel> hotels;

    @ManyToOne
    @JoinColumn(name = "sub_city_id")
    private SubCity subCity;
}
