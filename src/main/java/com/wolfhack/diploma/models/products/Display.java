package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Getter @Setter
public class Display {
    private enum Type {
        TN,
        IPS,
        PLS,
        VA,
        MVA,
        OLED
    }
    private enum Resolution {
        FullHD_1920x1080,
        QuadHD_1440x1080;
    }

    public Resolution resolution;
    public Type type;

    private float diagonal;
    private int freq;

}
