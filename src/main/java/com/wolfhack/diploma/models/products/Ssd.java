package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;

@Document("ssd")
@Getter @Setter
public class Ssd extends Product {
    public enum Type {
        Внешний,
        Встраиваемый
    }

    private Type type;
    private long size;
    private long readerSpeed;
    private long writerSpeed;

    @Override
    public String getCatalog() {
        return "Ssd_";
    }

}
