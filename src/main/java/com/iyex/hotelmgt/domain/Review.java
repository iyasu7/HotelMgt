package com.iyex.hotelmgt.domain;

import com.iyex.hotelmgt.domain.account.Guest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String review;

    @ManyToMany
    @JoinTable(
            name = "review_likes",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private Set<Guest> likes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    public void like(Guest guest){
        likes.add(guest);
    }
    public void dislike(Guest guest){
        likes.remove(guest);
    }


}
