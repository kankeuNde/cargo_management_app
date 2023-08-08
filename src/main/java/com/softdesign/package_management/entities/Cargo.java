package com.softdesign.package_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table//(name = "cargo")
@NoArgsConstructor @AllArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargo_id;
    private String title;
    @Enumerated(EnumType.STRING)
    private STATUS status;
    /*@OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval=true
    )
    @JoinColumn(name ="pckitems_id")
    private List<PackageItems> packages = new ArrayList<>();*/



}
