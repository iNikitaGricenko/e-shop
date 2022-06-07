package com.wolfhack.diploma.models.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.lang.management.MemoryType;

@Document("gpu")
@Getter @Setter
public class Gpu extends Product {

    enum Type {
        Дискретная,
        Интегрированная
    }

    private String type;
    private long memorySize;
    private String memoryType;
    private double memoryBus;

    private String graphicsProcessor;
    private double coreFrequency;
    private double videoMemoryFrequency;
    private String maxResolution;
    private String processorFamily;

    private boolean cudaSupport; //Поддержка CUDA
    private boolean additionalPowerSupply; //Необходимость дополнительного питания
    private double length; //Длина видеокарты
    private double height; //Высота видеокарты
    private double powerSupplyCapacity; //Рекомендуемая мощность БП
    private int fans; //Количество вентиляторов
    private int slots; //Кол-во занимаемых слотов
    private int cudaCores; //Количество ядер CUDA
    private String standardsSupport; //Поддержка стандартов
    private String supplyConnector; //Разъем доп. питания

    private String lighting;
    private String gpuInterface;
    private String connectors;


    @Override
    public String getCatalog() {
        return "Gpu_";
    }

}
