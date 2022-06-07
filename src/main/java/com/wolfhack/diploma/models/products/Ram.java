package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.lang.management.MemoryType;

@Document("ram")
@Getter @Setter
public class Ram extends Product{

    private String type;
    private long size;
    private String formFactor;
    private float freq;
    private double bandwidth;
    private String casLatency;
    private String timingScheme;
    private String eccMemory;
    private String xmp;
    private float voltage;

    private String worksTemperature;
    private String storageTemperature;

    @Override
    public String getCatalog() {
        return "Ram_";
    }
}
