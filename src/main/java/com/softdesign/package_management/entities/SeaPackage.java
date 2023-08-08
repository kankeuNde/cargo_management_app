package com.softdesign.package_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Data
@Table//(name = "sea_package")
@AllArgsConstructor
public class SeaPackage extends Package{
    private double volume;
    private BigDecimal unitPriceCBM;

    public SeaPackage(){
        super();
    }
    public SeaPackage(Long id, String itemName, String description, double volume, BigDecimal unitPriceCBM){
        super(id,itemName, description);
        this.unitPriceCBM = unitPriceCBM;
        this.volume = volume;
    }
}
