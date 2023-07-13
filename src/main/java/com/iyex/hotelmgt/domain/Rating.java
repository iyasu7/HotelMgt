package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.iyex.hotelmgt.domain.account.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "guest_id",nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "hotel_id",nullable = false)
    @JsonBackReference
    private Hotel hotel;

    @Column(nullable = false)
    private int rating;

}
