package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document("power_supply")
@Getter @Setter
public class PowerSupply extends Product {

    private String formFactor;
    private double powerUnderLoad;
    private double power;
    private double fan;
    private String gpuConnectors;
    private String motherboardConnectors;
    private String efficiency; // КПД
    private String powerFactorCorrection;

    private HashMap<String, String> outputCharacteristics = new HashMap<>();

    private HashMap<String, String> connectors = new HashMap<>();

    @Override
    public String getCatalog() {
        return "Power_supply_";
    }
}
