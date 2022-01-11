package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.management.MemoryType;

@Entity
@Table(name = "RAM")
public class Ram extends Product{

    @Getter @Setter
    private MemoryType type;

    @Getter @Setter
    private long size;

    @Getter @Setter
    private long maxSize;

    @Getter @Setter
    private long freq;

    @Override
    public String getCatalog() {
        return "Ram_";
    }
}
