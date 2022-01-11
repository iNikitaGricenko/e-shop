package com.wolfhack.diploma.models.products;

import com.wolfhack.diploma.models.Display;
import com.wolfhack.diploma.models.enums.Color;
import com.wolfhack.diploma.models.enums.OS;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Getter @Setter
@Entity
@Table(name = "Laptop")
public class Laptop extends Product{

    public Laptop() {
    }


    @NotNull
    private double cost;

    @ElementCollection
    @CollectionTable(name = "Comments", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "comment")
    private List<String> comments = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpu_id")
    private Cpu cpu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gpu_id")
    private Gpu gpu;

    @OneToOne
    @JoinColumn(name = "display_id")
    private Display display;
    private String displayCoverage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ram_id")
    private Ram ram;

    private int ramSlots;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ssd_id")
    private Ssd ssd;

    private String ports1,
            ports2,
            ports3,
            ports4,
            ports5,
            ports6,
            ports7,
            ports8,
            ports9;

    private String wirelessTech1, wirelessTech2;

    private String multimedia, multimediaOptionally;

    private String battery;

    private String volume;
    private OS OS;

    private String features1, features2, features3, features4, features5;

    private String additionally1, additionally2, additionally3;

    private String dimensions;
    private float weight;

    private Color color;

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

    public String[] getPortsArray() {
        return new String[]{ports1, ports2, ports3, ports4, ports5, ports6, ports7, ports8, ports9};
    }

    public String[] getWirelessTechArray() {
        return new String[]{wirelessTech1, wirelessTech2};
    }

    public String[] getMultimediaArray() {
        return new String[]{multimedia, multimediaOptionally};
    }

    public Map getOptionallyMap() {
        Map optionallyMap = new HashMap<String, String>();
        optionallyMap.put("OS", OS);
        optionallyMap.put("features1", features1);
        optionallyMap.put("features2", features2);
        optionallyMap.put("features3", features3);
        optionallyMap.put("features4", features4);
        optionallyMap.put("features5", features5);
        optionallyMap.put("additionally1", additionally1);
        optionallyMap.put("additionally2", additionally2);
        optionallyMap.put("additionally3", additionally3);
        optionallyMap.put("dimensions", dimensions);
        optionallyMap.put("weight", weight + " КГ");
        optionallyMap.put("color", color);
        optionallyMap.put("volume", volume);
        return optionallyMap;
    }
}
