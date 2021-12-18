package com.example.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


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
    @NotNull
    private boolean isActive;

    @Column
    @ManyToMany
    private Set<UserRole> userRoles;
}
