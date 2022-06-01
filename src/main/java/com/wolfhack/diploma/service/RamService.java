package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.Ram;
import com.wolfhack.diploma.repository.RamRepository;
import com.wolfhack.diploma.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class RamService {

    private final RamRepository ramRepository;

    public Page<Ram> findAll(Pageable pageable) {
        return ramRepository.findAll(pageable);
    }

    public void save(Ram ram, MultipartFile[] photos) throws IOException {
        Ram savedLaptop = ramRepository.save(ram);
        String uploadDir = "photos/product-photos/"+savedLaptop.getCatalog()+savedLaptop.getName()+"_"+savedLaptop.getId();
        FileUploadUtil.trySaveFile(uploadDir, savedLaptop.getPhotoNames(), photos);
    }

    public boolean exists(Ram ram) {
        return ramRepository.existsProductByNameAndModel(ram.getName(), ram.getModel());
    }

}
