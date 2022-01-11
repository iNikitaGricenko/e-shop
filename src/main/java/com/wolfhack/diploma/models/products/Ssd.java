package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SSD")
public class Ssd extends Product {
    enum Type {
        Внешний,
        Встраиваемый
    }

    @Override
    public String getCatalog() {
        return "Ssd_";
    }

    @Getter @Setter
    private Type type;

    @Getter @Setter
    private long size;

    @Getter @Setter
    private long readerSpeed;

    @Getter @Setter
    private long writerSpeed;


}
