package com.iyex.hotelmgt.domain.address;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "district")
    private SubCity subCity;
}
