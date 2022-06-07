package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;

@Document("ssd")
@Getter @Setter
public class Ssd extends Product {
    public enum Type {
        Внешний,
        Встраиваемый
    }

    private String formFactor;
    private String memorySize;
    private String memorySlotsType;
    private String interfaceType;
    private String nvme;
    private String controller;
    private long readerSpeed;
    private long writerSpeed;

    private String MTBF; // Время наработки на отказ
    private double impactResistance;
    private float powerRequirement;
    private String worksTemperature;
    private String storageTemperature;

    private HashSet<String> additionally;

    @Override
    public String getCatalog() {
        return "Ssd_";
    }

}
