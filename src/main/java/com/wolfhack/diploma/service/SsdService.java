package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.Ssd;
import com.wolfhack.diploma.repository.SsdRepository;
import com.wolfhack.diploma.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SsdService {

    private final SsdRepository ssdRepository;

    public Page<Ssd> findAll(Pageable pageable) {
        return ssdRepository.findAll(pageable);
    }

    public void save(Ssd ssd, MultipartFile[] photos) throws IOException {
        Ssd savedLaptop = ssdRepository.save(ssd);
        String uploadDir = "photos/product-photos/"+savedLaptop.getCatalog()+savedLaptop.getName()+"_"+savedLaptop.getId();
        FileUploadUtil.trySaveFile(uploadDir, savedLaptop.getPhotoNames(), photos);
    }

    public boolean exists(Ssd ssd) {
        return ssdRepository.existsProductByNameAndModel(ssd.getName(), ssd.getModel());
    }

    public void save(Ssd ssd) {
        ssdRepository.save(ssd);
    }

    public Ssd findById(String id) {
        return ssdRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
