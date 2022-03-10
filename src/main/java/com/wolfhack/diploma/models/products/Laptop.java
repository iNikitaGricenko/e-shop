package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Document("laptop")
@Getter @Setter
public class Laptop extends Product{

    private double cost;
    private String dimensions;
    private float weight;

    private Cpu cpu;
    private Gpu gpu;

    private Display display;
    private String displayCoverage;

    private Ram ram;
    private int ramSlots;

    private Color color;
    private Ssd ssd;

    private String multimedia, multimediaOptionally;
    private String battery;

    private String volume;
    private OS OS;

    private String[] wirelessTech;
    private List<String> comments = new ArrayList<>();
    private List<String> ports;
    private List<String> features;
    private List<String> additionally;

    @Override
    public String getCatalog() {
        return "Laptop_";
    }

    public Map getDisplayMap() {
        Map displayMap = new HashMap<String, String>();
        displayMap.put("diagonal", display.getDiagonal() + "″");
        displayMap.put("resolution", display.resolution);
        displayMap.put("matrix type", display.type);
        displayMap.put("freq", display.getFreq() + " Гц");
        displayMap.put("coverage", displayCoverage);
        return displayMap;
    }

    public String[] getMultimediaArray() {
        return new String[]{multimedia, multimediaOptionally};
    }

    public Map getOptionallyMap() {
        Map optionallyMap = new HashMap<String, String>();
        optionallyMap.put("OS", OS);
        optionallyMap.put("features", features);;
        optionallyMap.put("additionally", additionally);
        optionallyMap.put("dimensions", dimensions);
        optionallyMap.put("weight", weight + " КГ");
        optionallyMap.put("color", color);
        optionallyMap.put("volume", volume);
        return optionallyMap;
    }
}
