package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.Laptop;
import com.wolfhack.diploma.repository.LaptopRepository;
import com.wolfhack.diploma.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public void save(Laptop laptop, MultipartFile[] photos) throws IOException {
        Laptop savedLaptop = laptopRepository.save(laptop);
        String uploadDir = "photos/product-photos/"+savedLaptop.getCatalog()+savedLaptop.getName()+"_"+savedLaptop.getId();
        FileUploadUtil.trySaveFile(uploadDir, savedLaptop.getPhotoNames(), photos);
    }

    public boolean exists(Laptop laptop) {
        return laptopRepository.existsProductByNameAndModel(laptop.getName(), laptop.getModel());
    }

    public Laptop findByNameAndModel(String productName, String productModel) {
        productName= productName.replace("-", " ");
        return (Laptop) laptopRepository.findByNameIsLikeAndModelIsLike(productName.replace("-", " "), productModel);
    }

    public List<Laptop> filterByMaxCost(double maxCost) {
        if (maxCost != 0) {
            return laptopRepository.findLaptopsByCostLessThanEqual(maxCost);
        }
        return laptopRepository.findAll();
    }

    public Page<Laptop> findAll(Pageable pageable) {
        return laptopRepository.findAll(pageable);
    }

    public Laptop findById(String id) {
        return laptopRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public void save(Laptop laptop) {
        laptopRepository.save(laptop);
    }
}
