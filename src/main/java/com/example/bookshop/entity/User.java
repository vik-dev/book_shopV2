package com.example.bookshop.entity;


import com.example.bookshop.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;

    private Double money;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true)
    private String password;

    @Column(unique = true, nullable = false)
    private String login;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
