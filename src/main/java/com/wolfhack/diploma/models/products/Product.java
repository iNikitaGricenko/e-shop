package com.wolfhack.diploma.models.products;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter @Setter
@Embeddable
public abstract class Product {

    @Id
    protected String id;

    protected String name;

    protected String model;

    private double cost;

    @Setter(AccessLevel.NONE)
    protected String photo1,
                photo2,
                photo3,
                photo4,
                photo5;

    public void setPhoto1(MultipartFile photo1) { this.photo1 = photo1.getOriginalFilename(); }
    public void setPhoto2(MultipartFile photo2) { this.photo2 = photo2.getOriginalFilename(); }
    public void setPhoto3(MultipartFile photo3) { this.photo3 = photo3.getOriginalFilename(); }
    public void setPhoto4(MultipartFile photo4) { this.photo4 = photo4.getOriginalFilename(); }
    public void setPhoto5(MultipartFile photo5) { this.photo5 = photo5.getOriginalFilename(); }

    public abstract String getCatalog();

    public String[] getPhotoNames() {
        return new String[]{photo1, photo2, photo3, photo4, photo5};
    }

    public String[] getPhotos() {
        String[] photos = new String[]{
                "photos/product-photos/"+getCatalog()+name+"_"+id+"/"+this.photo1,
                "photos/product-photos/"+getCatalog()+name+"_"+id+"/"+this.photo2,
                "photos/product-photos/"+getCatalog()+name+"_"+id+"/"+this.photo3,
                "photos/product-photos/"+getCatalog()+name+"_"+id+"/"+this.photo4,
                "photos/product-photos/"+getCatalog()+name+"_"+id+"/"+this.photo5
        };
        return photos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && model.equals(product.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
