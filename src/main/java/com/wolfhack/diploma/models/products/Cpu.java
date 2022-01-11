package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "CPU")
public class Cpu extends Product {

    @Getter @Setter
    private long cores;
    @Getter @Setter
    private long threads;
    @Getter @Setter
    private long cacheSize;

    @Getter @Setter
    private int performance;

    @Override
    public String getCatalog() {
        return "Cpu_";
    }
}
