package com.iyex.hotelmgt.domain;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Account  {
    private String firstName;
    private String lastName;
    private String username;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
