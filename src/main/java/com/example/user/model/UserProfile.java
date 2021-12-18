package com.example.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@Entity
@Table(name = "users_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    @Size(min = 2)
    private String lastName;

    @Column(name = "first_name")
    @NotBlank
    @Size(min = 2)
    private String firstName;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @NotNull
    @OneToOne()
    private User user;


}
