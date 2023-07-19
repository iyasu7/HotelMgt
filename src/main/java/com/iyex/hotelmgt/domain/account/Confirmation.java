package com.iyex.hotelmgt.domain.account;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String confirmationLink;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Confirmation(User user) {
    this.user = user;
    this.createdDate = LocalDateTime.now();
    this.confirmationLink = UUID.randomUUID().toString();
    }
}
