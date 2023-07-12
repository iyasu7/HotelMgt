package com.iyex.hotelmgt.domain;

import com.iyex.hotelmgt.domain.account.User;
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

    private String hotelReview;

    @ManyToMany
    @JoinTable(
            name = "review_likes",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> likes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    public void like(User user){
        likes.add(user);
    }
    public void dislike(User user){
        likes.remove(user);
    }


}
