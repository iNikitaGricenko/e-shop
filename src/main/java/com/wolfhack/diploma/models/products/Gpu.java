package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.lang.management.MemoryType;

@Document("gpu")
@Getter @Setter
public class Gpu extends Product {

    enum Type {
        Дискретная,
        Интегрированная
    }

    private Type type;
    private long memorySize;
    private MemoryType memoryType;
    private int performance;

    @Override
    public String getCatalog() {
        return "Gpu_";
    }

}
