package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Document("cpu")
@Getter @Setter
public class Cpu extends Product {

    private long cores;
    private long threads;
    private long cacheSize;

    private int performance;

    @Override
    public String getCatalog() {
        return "Cpu_";
    }
}
