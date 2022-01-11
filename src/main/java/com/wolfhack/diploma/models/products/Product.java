package com.wolfhack.diploma.models.products;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    protected String name;

    @NotNull
    protected String model;

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

}
