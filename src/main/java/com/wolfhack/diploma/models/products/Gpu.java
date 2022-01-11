package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.management.MemoryType;

@Entity
@Table(name = "GPU")
public class Gpu extends Product {

    enum Type {
        Дискретная,
        Интегрированная
    }

    @Getter @Setter
    private Type type;

    @Getter @Setter
    private long memorySize;

    @Getter @Setter
    private MemoryType memoryType;

    @Getter @Setter
    private int performance;

    @Override
    public String getCatalog() {
        return "Gpu_";
    }

}
