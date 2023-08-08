package com.softdesign.package_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table//(name = "package_items")
@NoArgsConstructor
@AllArgsConstructor
public class PackageItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pckitems_id;
    /*@OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval=true
    )
    @JoinColumn(name = "pck_id")
    private List<Package> items = new ArrayList<>();*/
    @Enumerated(EnumType.STRING)
    private STATUS status;
}
