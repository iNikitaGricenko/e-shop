package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.lang.management.MemoryType;

@Document("ram")
@Getter @Setter
public class Ram extends Product{

    private MemoryType type;
    private long size;
    private long maxSize;
    private long freq;

    @Override
    public String getCatalog() {
        return "Ram_";
    }
}
