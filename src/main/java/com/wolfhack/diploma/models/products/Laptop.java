package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

import static com.wolfhack.diploma.models.products.OS.*;

@Document("laptop")
@Getter @Setter
public class Laptop extends Product{

    private String dimensions;
    private float weight;

    private Cpu cpu = new Cpu();
    private Gpu gpu = new Gpu();

    private Display display = new Display();
    private String displayCoverage;

    private Ram ram = new Ram();
    private int ramSlots;

    private Color color = Color.Black;
    private Ssd ssd = new Ssd();

    private String multimedia, multimediaOptionally;
    private String battery;

    private String volume;
    private OS OS = Linux;

    private String[] wirelessTech;
    private List<String> comments = new ArrayList<>();
    private List<String> ports = new ArrayList<>();
    private List<String> features = new ArrayList<>();
    private List<String> additionally = new ArrayList<>();

    @Override
    public String getCatalog() {
        return "Laptop_";
    }

    public Map getDisplayMap() {
        Map displayMap = new HashMap<String, String>();
        displayMap.put("diagonal", Optional.ofNullable(display).orElse(new Display()).getDiagonal() + "″");
        displayMap.put("resolution", Optional.ofNullable(display).orElse(new Display()).resolution);
        displayMap.put("matrix type", Optional.ofNullable(display).orElse(new Display()).type);
        displayMap.put("freq", Optional.ofNullable(display).orElse(new Display()).getFreq() + " Гц");
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
