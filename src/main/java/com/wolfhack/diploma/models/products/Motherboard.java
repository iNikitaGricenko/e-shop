package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.management.MemoryType;
import java.util.HashMap;

@Document("motherboard")
@Getter @Setter
public class Motherboard extends Product {

    private String type;
    private String socket;
    private String cpus;
    private String chipset;

    private String memoryType;
    private String compatibleRam;
    private int ramSlots;
    private int channelNumber;
    private double maxRamCapacity;
    private double minRamFreq;
    private double maxRamFreq;

    private String wirelessAdapter;

    private String soundCard;
    private float soundScheme;

    private HashMap<String, Integer> injectedPorts = new HashMap<>();

    private HashMap<String, Integer> powerConnectors = new HashMap<>();

    private HashMap<String, Integer> externalPorts = new HashMap<>();

    private String formFactor;

    @Override
    public String getCatalog() {
        return "Motherboard_";
    }
}
