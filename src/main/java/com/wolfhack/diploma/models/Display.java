package com.wolfhack.diploma.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public Resolution resolution;
    public Type type;

    @Getter @Setter
    private float diagonal;
    @Getter @Setter
    private int freq;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
