package com.example.simple.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table( name="user",
        uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class UserDAO {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable = false)
    private String password;
    @Column(name = "first_name_ua", nullable = false)
    private String firstNameUA;
    @Column(name = "last_name_ua", nullable = false)
    private String lastNameUA;

}
