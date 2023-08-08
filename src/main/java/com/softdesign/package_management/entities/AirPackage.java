package com.softdesign.package_management.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Data
@Table//(name = "air_package")
public class AirPackage extends Package{
    private BigDecimal unitPriceKgs;
    private double weight;

    public AirPackage(Long id, String itemName, String description, BigDecimal unitPriceKgs, double weight){
        super(id, itemName, description);
        this.unitPriceKgs = unitPriceKgs;
        this.weight = weight;
    }
    public AirPackage(){
        super();
    }
}
