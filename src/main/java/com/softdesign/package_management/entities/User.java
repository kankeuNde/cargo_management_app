package com.softdesign.package_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "`user`")
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean enabled;
    private boolean tokenExpired;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private List<Role> roles = new ArrayList<>();


    /*@OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval=true
    )
    @JoinColumn(name = "pckitems_id")
    private List<PackageItems> packageItemsList = new ArrayList<>();*/

}
