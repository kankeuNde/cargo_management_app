package com.softdesign.package_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@Entity
@Data
@Table//(name = "privilege")
@NoArgsConstructor @AllArgsConstructor
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long privilege_id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles = new ArrayList<>();

    public Privilege(String name) {
        this.name = name;
    }
}
