package com.softdesign.package_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data @NoArgsConstructor
@Table//(name = "package")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public class Package implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long pck_id;
    private String itemName;
    private String description;
    @Transient
    private BigDecimal totalPrice;

    public Package(Long id, String itemName, String description){
        super();
        this.pck_id = id;
        this.itemName = itemName;
        this.description = description;
    }

}
