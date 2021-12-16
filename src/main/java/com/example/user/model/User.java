package com.example.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    @NotBlank
    @Size(min = 8, max = 80)
    private String email;

    @Column(length = 80)
    @NotBlank
    @Size(min = 8, max = 80)
    private String password;

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

    @Column
    private String country;

    @Column
    private String region;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private Integer house;



    public void setBirthDay(LocalDate birthDay) {
        long ear = ChronoUnit.YEARS.between(birthDay, LocalDate.now());

        if (ear < 18) {
            this.birthDay = null;
        }
        this.birthDay = birthDay;
    }


}
