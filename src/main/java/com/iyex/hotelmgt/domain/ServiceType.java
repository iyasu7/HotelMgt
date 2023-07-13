package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ServiceTypeName;

    @OneToMany(mappedBy = "serviceType")
    @JsonManagedReference
    private Set<Service> services;
}